import greenfoot.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Font;
import java.awt.GraphicsEnvironment;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PromptTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PromptTwo extends World
{
    private Button next;

    /**
     * Constructor for objects of class PromptTwo.
     * 
     */
    public PromptTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        
        Label title = new Label("Note:" );
        title.setColor( Color.black );
        title.setSize( 20 );
        addObject( title, 200, 60 );
       
        Label line1 = new Label( "The higher the temperature the faster the sound velocity in air." );
        line1.setColor( Color.black );
        line1.setSize( 18 );
        addObject( line1, 400, 100 );
        
        Label line2 = new Label( "This is because at higher temperatures, the molocules in the air are" );
        line2.setColor( Color.black );
        line2.setSize( 18 );
        addObject( line2, 400, 120 );
        
        Label line3 = new Label( "more active, making it easier for sound to travel through the median." );
        line3.setColor( Color.black );
        line3.setSize( 18 );
        addObject( line3, 400, 140 );
        
        Label line4 = new Label( "Humidity has a small but measurable effect on the speed of sound. It can" );
        line4.setColor( Color.black );
        line4.setSize( 18 );
        addObject( line4, 400, 180 );
        
        Label line5 = new Label( "increase speed by a factor anywhere from 0.1 m/s ~ 0.6 m/s. Because of the small" );
        line5.setColor( Color.black );
        line5.setSize( 18 );
        addObject( line5, 400, 220 );
        
        Label line6 = new Label( "difference in value, we always consider the effects of humidty to be at" );
        line6.setColor( Color.black );
        line6.setSize( 18 );
        addObject( line6, 400, 240 );
        
        Label line7 = new Label( "the higher end and keep it constant at 0.6 m/s." );
        line7.setColor( Color.black );
        line7.setSize( 18 );
        addObject( line7, 400, 280 );
        
        Label line8 = new Label( "Speed travels at approximately at 331.4 m/s at 0 degrees Celsius." );
        line8.setColor( Color.black );
        line8.setSize( 18 );
        addObject( line8, 400, 320 );
        
        //Final next button
        next = new Button("Next", new Point(100, 50));
        next.setBackground(Color.green);
        addObject( next, 700, 375 );
    }
    
    public void act(){
        if (next.wasClicked())
        {
            // Do something
            Greenfoot.setWorld(new InputWorld());            
        }        
        
    }
}
