import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class SoundWave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoundWave extends Actor
{
    private static final int EAST = 1;
    private static final int WEST = -1;
    private static final int NORTH = 2;
    private static final int SOUTH = -2;

    private int direction;
    private int wave;
    
    private SonarWorld sw = (SonarWorld)getWorld();
    
    public SoundWave()
    {
        //Code here
    }
    
    public SoundWave( int dir, int num )
    {
        setDirection(dir);
        wave = num;
        
        switch( wave ){
            case 0: getImage().scale( 12, 46 );
                    break;
            case 1: getImage().scale( 12, 36 );
                    break;
            case 2: getImage().scale( 12, 26 );
                    break;
            default: break;
        }
        
    }
    
    /**
     * Act - do whatever the SoundWave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {        
        if(canMove()){
            move();
        }
        
        
        if( hitSquare() ){
            setDirection( -direction );
        }
        
    }
    
    public void move()
    {
        //If you cant move return
        if (!canMove()) {
            return;
        }
        //If you can move then move
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
    }
    
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
            
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
            
        // test for outside border
        List<Square> ofSquares = myWorld.getObjectsAt( x, y, Square.class );
        
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }        
        else if( !ofSquares.isEmpty()){
            return false;
        }
        
        return true;
    }
    
    public void setDirection(int dir)
    {
        this.direction = dir;
        switch(direction) {
            case SOUTH :
                setRotation(90);
                break;
            case EAST :
                setRotation(0);
                break;
            case NORTH :
                setRotation(270);
                break;
            case WEST :
                setRotation(180);
                break;
            default :
                break;
        }
    }
    
    public boolean hitSquare(){
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        
        List<Square> ofSquares = myWorld.getObjectsAt( x, y, Square.class );
        
        if( !ofSquares.isEmpty() ){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getDirection(){
        return direction;
    }
    
}
