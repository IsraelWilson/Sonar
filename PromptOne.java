import greenfoot.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Font;
import java.awt.GraphicsEnvironment;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PromptOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PromptOne extends World
{
    private Button next;

    /**
     * Constructor for objects of class PromptOne.
     * 
     */
    public PromptOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        
        Label title = new Label("SONAR" );
        title.setColor( Color.black );
        title.setSize( 20 );
        addObject( title, 400, 25 );
       
        Label line1 = new Label( "The Sonar program is a technique use to find the distance between two fixed" );
        line1.setColor( Color.black );
        line1.setSize( 18 );
        addObject( line1, 400, 100 );
        
        Label line2 = new Label( "objects using sound waves and the parameter of temperature in the air. The" );
        line2.setColor( Color.black );
        line2.setSize( 18 );
        addObject( line2, 400, 115 );
        
        Label line3 = new Label( "user is required to input the time in which it takes their voice to travel" );
        line3.setColor( Color.black );
        line3.setSize( 18 );
        addObject( line3, 400, 130 );
        
        Label line4 = new Label( "from the object and back seconds(echo). In addition the user is required to" );
        line4.setColor( Color.black );
        line4.setSize( 18 );
        addObject( line4, 400, 145 );
        
        Label line5 = new Label( "input the current temperature in air (Celsius/Fahrenheit)." );
        line5.setColor( Color.black );
        line5.setSize( 18 );
        addObject( line5, 400, 160 );
        
        Label line6 = new Label( "The basis of Sonar stems from the speed of sound equation;" );
        line6.setColor( Color.black );
        line6.setSize( 18 );
        addObject( line6, 400, 185 );
        
        Label line7 = new Label( "the speed of sound is determined by the conditions of air" );
        line7.setColor( Color.black );
        line7.setSize( 18 );
        addObject( line7, 400, 200 );
        
        Label line8 = new Label( "itself (e.g. humidity, temperature, and altitude). It is not" );
        line8.setColor( Color.black );
        line8.setSize( 18 );
        addObject( line8, 400, 215 );
        
        Label line9 = new Label( "dependent on the sounds amplitude, frequency, or wavelength." );
        line9.setColor( Color.black );
        line9.setSize( 18 );
        addObject( line9, 400, 230 );
        
        Label line10 = new Label( "To calculate the approximate speed of sound in dry air at sea level" );
        line10.setColor( Color.black );
        line10.setSize( 18 );
        addObject( line10, 400, 245 );
        
        Label line11 = new Label( "is represented by the following formula:" );
        line11.setColor( Color.black );
        line11.setSize( 18 );
        addObject( line11, 400, 260 );
        
        Label line12 = new Label( "v = 331.4 m/s + 0.6 m/s * T celsius" );
        line12.setColor( Color.black );
        line12.setSize( 25 );
        addObject( line12, 400, 300 );        
        
         
        
        //Final next button
        next = new Button("Next", new Point(100, 50));
        next.setBackground(Color.green);
        addObject( next, 700, 375 );
    }
    
    public void act(){
        if (next.wasClicked())
        {
            // Do something
            Greenfoot.setWorld(new PromptTwo());            
        }        
        
    }
    
}
