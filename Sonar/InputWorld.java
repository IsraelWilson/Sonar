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
    private Button underwater;
    private Button calculate;
    
    private TextBox nameBox;
    private TextBox echoBox;
    private TextBox tempBox;
    
    String name;
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
        name = "name";
        echo = "0";
        temp = "0";
        
        addObject( new Label("Sonar Calculator"), 400, 50 );
        
        addObject( new Label("Object name"), 300, 100 );
        nameBox = new TextBox(new Point(100, 15), "", new Font("Times-Roman", Font.PLAIN, 14));
        addObject( nameBox, 400, 100 );
        
        
        addObject( new Label("Echo Time (seconds)"), 325, 150 );
        echoBox = new TextBox(new Point(100, 15), "", new Font("Times-Roman", Font.PLAIN, 14));
        addObject( echoBox, 450, 150 );
        
        
        addObject( new Label("Temperature"), 300, 200 );
        tempBox = new TextBox(new Point(100, 15), "", new Font("Times-Roman", Font.PLAIN, 14));
        addObject( tempBox, 400, 200 );
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
        underwater = new Button("Underwater", new Point(75, 15));
        surface.setBackground(Color.yellow);
        underwater.setBackground(Color.cyan);
        addObject( surface, 300, 300 );
        addObject( underwater, 380, 300 );
        
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
        if (underwater.wasClicked())
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
                name = nameBox.getText();
                double echo = Double.parseDouble( echoBox.getText() );                
                double temp = Double.parseDouble( tempBox.getText() );
                
                //Change worlds and display sound wave
                if( theLevel == 0 )
                {
                    Greenfoot.setWorld(new SonarWorld(echo, temp, name, theTemp));
                }
                else if ( theLevel == 1 )
                {
                    Greenfoot.setWorld(new SonarWorldW(echo, temp, name, theTemp));
                }
                else{
                    world = 1;
                }
            }
        }
    }
}