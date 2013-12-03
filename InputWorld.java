import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
import java.util.Collections;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import java.awt.Point;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InputWorld here.
 * This class uses the Java Abstract Window Toolkit (AWT)
 * for creating user interfaces and for painting graphics and images
 * 
 * @author Israel Wilson 
 * @version 11/04/2013
 */
public class InputWorld extends World
{
    private int world;
    private int theLevel;
    private int theTemp;
    
    private Button celsius;
    private Button fahrenheit;
    private Button surface;
    private Button space;
    private Button calculate;
    
    private TextBox echoBox;
    private TextBox tempBox;
    
    String echo;
    String temp;

    /**
     * Constructor for objects of class InputWorld.
     * 
     */
    public InputWorld()
    {           
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        setPaintOrder(GUI.class);
        
        //Surface level and type of temperature
        theLevel = 0;
        theTemp = 0;
        
        //Give default vales to references when world is created
        echo = "0";
        temp = "0";
        
        Label title = new Label("Sonar Calculator" );
        title.setColor( Color.white );
        title.setSize( 20 );
        addObject( title, 400, 75 );
        
        //Time
        addObject( new Label("Echo Time"), 285, 150 );
        echoBox = new TextBox(new Point(100, 15), "", new Font("Times-Roman", Font.PLAIN, 14));
        addObject( echoBox, 400, 150 );
        
        addObject( new Label("(SECONDS)"), 495, 150 );
        
        //Temperature
        addObject( new Label("Temperature"), 300, 200 );
        tempBox = new TextBox(new Point(100, 15), "", new Font("Times-Roman", Font.PLAIN, 14));
        addObject( tempBox, 400, 200 );
        
        addObject( new Label("(CHOOSE CELSIUS or FAHRENHEIT)"), 565, 200 );
        
        //Buttons for temperature
        celsius = new Button("C", new Point(50, 15));
        fahrenheit = new Button("F", new Point(50, 15));
        celsius.setBackground(Color.red);
        fahrenheit.setBackground(Color.blue);
        addObject( celsius, 370, 225 );
        addObject( fahrenheit, 430, 225 );
        
        addObject( new Label("Choose sea level:"), 310, 275 );
        //Buttons for sea level
        surface = new Button("Surface", new Point(75, 15));
        space = new Button("Space", new Point(75, 15));
        surface.setBackground(Color.yellow);
        space.setBackground(Color.cyan);
        addObject( surface, 300, 300 );
        addObject( space, 380, 300 );
        
        //Final Calculate button
        calculate = new Button("Calculate", new Point(100, 50));
        calculate.setBackground(Color.green);
        addObject( calculate, 400, 375 );
        
        //Counter for the world we are in
        world = 1;
        
    }
    
    public void act()
    {
        // Listen for if the Button is clicked
        if (celsius.wasClicked())
        {
            // Do something
            theTemp = 0;
            fahrenheit.setBackground( Color.GRAY );
            celsius.setBackground( Color.RED );
            
        }
        
        // Listen for if the Button is clicked
        if (fahrenheit.wasClicked())
        {
            // Do something
            theTemp = 1;
            
        }
        
        // Listen for if the Button is clicked
        if (surface.wasClicked())
        {
            // Do something
            theLevel = 0;
            
        }
        
        // Listen for if the Button is clicked
        if (space.wasClicked())
        {
            // Do something
            theLevel = 1;
            
        }
        
        // Listen for if the Button is clicked
        if (calculate.wasClicked())
        {
            // Do something
            if(world == 1){
                world = 2;
                
                //Get values stored in text boxes
                //Convert to doubles
                double echo = Double.parseDouble( echoBox.getText() );                
                double temp = Double.parseDouble( tempBox.getText() );
                
                //Change worlds and display sound wave
                if( theLevel == 0 )
                {
                    Greenfoot.setWorld(new SonarWorld(echo, temp, theTemp));
                }
                else if ( theLevel == 1 )
                {
                    Greenfoot.setWorld(new SonarWorldS());
                }
                else{
                    world = 1;
                }
            }
        }
    }
}