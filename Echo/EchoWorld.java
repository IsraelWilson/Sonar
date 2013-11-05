import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EchoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EchoWorld extends World
{

    /**
     * Constructor for objects of class EchoWorld.
     * 
     */
    public EchoWorld()
    {
        this ( new Calculate() );
    }
    
    public EchoWorld(Calculate calc)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        
        addObject( new Square(), 50, 200 );
        addObject( new Square(), 750, 200 );
        
        addObject( new SoundWave(), 150, 200 );
    }
}
