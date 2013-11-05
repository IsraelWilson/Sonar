import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A little penguin that wants to get to the other side.
 */
public class Pengu extends Mover
{
    private static final int jumpStrength = 16;
    private int level;
    private int jumped = 0;   // count how often we've jumped
    
    public Pengu()
    {
        level = 1;
    }
    
    public void act() 
    {
        checkKeys();        
        checkFall();
        checkNextLevel();
    }
    
    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("left") )
        {
            setImage("pengu-left.png");
            moveLeft();
        }
        if (Greenfoot.isKeyDown("right") )
        {
            setImage("pengu-right.png");
            moveRight();
        }
        if (Greenfoot.isKeyDown("space") )
        {
            if (onGround())
                jump();
        }
    }    
    
    private void jump()
    {
        setVSpeed(-jumpStrength);
        fall();
        jumped++;
    }
    
    private void checkFall()
    {
        if (onGround()) {
            setVSpeed(0);
        }
        else {
            fall();
        }
    }

    /**
     * Check whether we should go to the next level, and if yes, start the next level.
     */
    private void checkNextLevel()
    {
        if (getX() == getWorld().getWidth()-1) {
            if (level == 1) {
                level = 2;
                getWorld().removeObject(this);
                Greenfoot.setWorld(new Level2(this));
            }
            else {
                level = 1;
                getWorld().removeObject(this);
                Greenfoot.setWorld(new Level1(this));
            }
        }
    }


}

    