import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    

    /**
     * Constructor for objects of class EchoWorld.
     * 
     */
    public SonarWorld()
    {
        super(800, 400, 1);
    }
    
    public SonarWorld( double e, double t, String n )
    {
       super(800, 400, 1);
       //Deault reference values
       name = n;
       echo = e;
       temp = t;
       distance = getDistance();
       
       addObject( new Label("Source"), 50, 175 );
       addObject( new Square(), 50, 200 );
        
       addObject( new Label( name ), 750, 175 );
       addObject( new Square(), 750, 200 );
        
       addObject( new SoundWave(), 150, 200 );
       
       //Show the calculated distance
       addObject( new Label("The distance from SOURCE to " + name + " is " + distance ), 400, 300 );
    }
    
    public double getDistance()
    {
        //Convert string data into double value
        double echoVal = echo;
        double tempVal = temp;
        
        double velocity = ( 331.5 + ( 0.6 * tempVal ) );
        distance = ( ( velocity * echoVal )/ 2 );        
        
        return distance;
    }
}
