import greenfoot.*;
import java.awt.Color;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EchoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SonarWorld extends World
{
    String name;
    double echo;
    double temp;
    double distance;
    int leftSquare;
    int rightSquare;
    

    /**
     * Constructor for objects of class EchoWorld.
     * 
     */
    public SonarWorld()
    {
        super(800, 400, 1);
    }
    
    public SonarWorld( double e, double t, String n, int passT )
    {
       super(800, 400, 1);
       //Deault reference values
       name = n;
       echo = e;
       temp = t;
       distance = getDistance( passT );
       
       //Set the distance between the squares
       //Distance can not be grater than 650
       //Sqaure width = 75
       leftSquare = 325 - ((int)(echo/4));
       rightSquare = 475 + ((int)(echo/4));
       
       //Sqaure Object
       addObject( new Square(), leftSquare, 200 );
       addObject( new Square(), rightSquare, 200 );
       
       
       //Sound wave object
       //addObject( new SoundWave( 1 ), leftSquare + 75, 200 );
       
       //Timer Object
       addObject( new Timer(), 0, 0 );
       
       //Show the calculated distance
       Label caption = new Label("The distance from SOURCE to " + name + " is " + distance );
       caption.setColor( Color.white );
       caption.setSize( 20 );
       addObject( caption, 400, 300 );
       
       
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
    
    public int getLSquare(){
        return leftSquare;
    }
    
    public int getRSquare(){
        return rightSquare;
    }    
    
}
