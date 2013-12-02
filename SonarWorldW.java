import greenfoot.*;
import java.awt.Color;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EchoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SonarWorldW extends World
{
    String name;
    double echo;
    double temp;
    double distance;
    

    /**
     * Constructor for objects of class EchoWorld.
     * 
     */
    public SonarWorldW()
    {
        super(800, 400, 1);
    }
    
    public SonarWorldW( double e, double t, String n, int passT )
    {
       super(800, 400, 1);
       //Deault reference values
       name = n;
       echo = e;
       temp = t;
       distance = getDistance( passT );
       
       addObject( new Label("Source"), 50, 175 );
       addObject( new Square(), 50, 200 );
        
       addObject( new Label( name ), 750, 175 );
       addObject( new Square(), 750, 200 );
        
      // addObject( new SoundWave( 0 ), 150, 200 );
       
       //Show the calculated distance
       Label caption = new Label("The distance from SOURCE to " + name + " is " + distance );
       caption.setColor( Color.white );
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
    
}
