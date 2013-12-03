import greenfoot.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Font;
import java.awt.GraphicsEnvironment;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SonarWorldS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SonarWorldS extends World
{
    private Button reset;
    private Button input;

    /**
     * Constructor for objects of class SonarWorldS.
     * 
     */
    public SonarWorldS()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        
        Label title = new Label("SPACE" );
        title.setColor( Color.white );
        title.setSize( 20 );
        addObject( title, 400, 25 );
       
        Label line1 = new Label( "Since sound needs a median to travel through such as a liquid, solid, or gas (air)" );
        line1.setColor( Color.white );
        line1.setSize( 18 );
        addObject( line1, 400, 100 );
        
        Label line2 = new Label( "The speed of sound is 0 in outer space. Space is a vacuum and thus, contains" );
        line2.setColor( Color.white );
        line2.setSize( 18 );
        addObject( line2, 400, 115 );
        
        Label line3 = new Label( "none of the medians used by sound so travel. Furthermore, sound trasmission become" );
        line3.setColor( Color.white );
        line3.setSize( 18 );
        addObject( line3, 400, 130 );
        
        Label line4 = new Label( "weaker as the pressure of molecules decreases. Pressure in space is 0, thus sound" );
        line4.setColor( Color.white );
        line4.setSize( 18 );
        addObject( line4, 400, 145 );
        
        Label line5 = new Label( "transmission is 0. In other words there is no sound." );
        line5.setColor( Color.white );
        line5.setSize( 18 );
        addObject( line5, 400, 160 );
        
        //Final input button
        input = new Button("Input", new Point(100, 50));
        input.setBackground(Color.green);
        addObject( input, 700, 375 );
        
        //Final reset button
        reset = new Button("Reset", new Point(100, 50));
        reset.setBackground(Color.green);
        addObject( reset, 100, 375 );
    }
    
    public void act(){
        if (reset.wasClicked())
        {
            // Do something
            Greenfoot.setWorld(new PromptOne());            
        }
        
        if (input.wasClicked())
        {
            // Do something
            Greenfoot.setWorld(new InputWorld());            
        }    
        
    }
}
