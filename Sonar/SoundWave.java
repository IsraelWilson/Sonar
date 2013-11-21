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
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    private int direction;
    
    public SoundWave()
    {
        setDirection(EAST);
    }
    /**
     * Act - do whatever the SoundWave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        collision();
        
       if(canMove()) {
            move();
        }
        else {
            reflect();
        } // Add your action code here.
    }
    
    public void move()
    {
        if (!canMove()) {
            return;
        }
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
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        
        List squares = myWorld.getObjectsAt( x, y, Square.class );
        if( squares.isEmpty() ){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void setDirection(int direction)
    {
        this.direction = direction;
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
    
    public void reflect()
    {
        switch(direction) {
            case EAST :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(EAST);
                break;
        }
    }
    
    public void collision()
    {
        //SoundWave a = new SoundWave();
        Actor a = getOneIntersectingObject( Square.class );
        
        if( a != null )
        {
            //Reflect sounds waves all around for a dew seconds here
            World sw = getWorld();
            
            int X = a.getX();
            int Y = a.getY();
            
            Vibration nV = new Vibration();
            Vibration sV = new Vibration();
            Vibration eV = new Vibration();
            Vibration wV = new Vibration();
            
            nV.setDirection( 2 );
            sV.setDirection( 3 );
            eV.setDirection( 0 );
            wV.setDirection( 1 );
            
            sw.addObject( nV, X, Y - 50 );
            sw.addObject( sV, X, Y + 50 );
            sw.addObject( eV, X + 50, Y );
            sw.addObject( wV, X - 50, Y );
            
        }
        
    }
}
