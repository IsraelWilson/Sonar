import greenfoot.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Font;
import java.awt.GraphicsEnvironment;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EchoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SonarWorld extends World
{
    double echo;
    double temp;
    double distance;
    int leftSquare;
    int rightSquare;
    
    private Button reset;
    private Button input;
    

    /**
     * Constructor for objects of class EchoWorld.
     * 
     */
    public SonarWorld()
    {
        super(800, 400, 1);
    }
    
    public SonarWorld( double e, double t, int passT )
    {
       super(800, 400, 1);
       //Deault reference values
       echo = e;
       temp = t;
       distance = getDistance( passT );
       
       //Set the distance between the squares
       //Distance can not be grater than 650
       //Sqaure width = 75
       leftSquare = 325 - ((int)(echo/4));
       rightSquare = 475 + ((int)(echo/4));
       
       //Keep the boundaries of the waves inside the world
       if( leftSquare < -40 ){
           leftSquare = -40;
           rightSquare = 840;
        }
        
       //Sqaure Object
       addObject( new Square(), leftSquare, 200 );
       addObject( new Square(), rightSquare, 200 );
       
       
       //Sound wave object
       //addObject( new SoundWave( 1 ), leftSquare + 75, 200 );
       
       //Timer Object
       addObject( new Timer(), 0, 0 );
       
       //Show the calculated speed of sound
       Label caption = new Label("The speed of sound is " + getSpeed( passT ) + " m/s" );
       caption.setColor( Color.red );
       caption.setSize( 20 );
       addObject( caption, 400, 280 );
       
       //Show the calculated distance
       Label speedLabel = new Label("The objects are " + distance + " meters apart.");
       speedLabel.setColor( Color.red );
       speedLabel.setSize( 20 );
       addObject( speedLabel, 400, 300 );
       
       //Final input button
        input = new Button("Input", new Point(100, 50));
        input.setBackground(Color.green);
        addObject( input, 700, 375 );
        
        //Final reset button
        reset = new Button("Reset", new Point(100, 50));
        reset.setBackground(Color.green);
        addObject( reset, 100, 375 );
       
       
    }
    
    public double getDistance( int tempType )
    {
        //Convert string data into double value
        double echoVal = echo;
        double tempVal = temp;
         if( tempType == 1 ){
             double hold = tempVal - 32;
             tempVal = hold / 1.8;
             
            }
        
        double velocity = ( 331.5 + ( 0.6 * tempVal ) );
        distance = ( ( velocity * echoVal )/ 2 );        
        
        return distance;
    }
    
    public double getSpeed( int tempType )
    {
        //Convert string data into double value
        double echoVal = echo;
        double tempVal = temp;
         if( tempType == 1 ){
             double hold = tempVal - 32;
             tempVal = hold / 1.8;
             
            }
        
        double velocity = ( 331.5 + ( 0.6 * tempVal ) );       
        
        return velocity;
    }
    
    public int getLSquare(){
        return leftSquare;
    }
    
    public int getRSquare(){
        return rightSquare;
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
