import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InputWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InputWorld extends World
{

    /**
     * Constructor for objects of class InputWorld.
     * 
     */
    public InputWorld()
    {
        this ( new Calculate() );
    }
    
    public InputWorld( Calculate calc )
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        
        Name name = new Name();
        addObject( name, 400, 100 );
        
        Echo echo = new Echo();
        addObject( echo, 400, 150 );
        
        Temperature temperature = new Temperature();
        addObject( temperature, 400, 200 );
        
        addObject( new Celsius(), 325, 250 );
        addObject( new Fahrenheit(), 475, 250 );
        
        addObject( new Surface(), 325, 300 );
        addObject( new Underwater(), 475, 300 );
        
        addObject( calc, 400, 380 );
    }
}
