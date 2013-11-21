import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vibration here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vibration extends SoundWave
{
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    long startTime;
    private int direction;
    /**
     * Act - do whatever the Vibration wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Vibration()
    {
        startTime = System.currentTimeMillis();
        setDirection(EAST);
    }
    
    public void act() 
    {
        // Add your action code here.
        long currentTime = System.currentTimeMillis();
        int durationMillis = (int)( currentTime - startTime );
        
        int durationSecs = durationMillis / 1000;
        
        if(canMove()) {
            move();
        }
        else if ( durationSecs == 1) {
            getWorld().removeObject(this);
        }
        else{
            getWorld().removeObject(this);            
        }
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
        
        return true;
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
    
}
