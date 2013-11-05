import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    /**
     * Default constructor. If we don't receive a game character, create one.
     */
    public Level2()
    {    
        this(new Pengu());
    }

    /**
     * Constructor used during play - the game character is passed in.
     */
    public Level2(Pengu pengu)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 500, 1); 
        
        addObject ( new Ground("ground2.png"), 112, 337);
        addObject ( new Ground("ground2.png"), 570, 270);
        addObject ( pengu, 66, 244 );
    }
}
