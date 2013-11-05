import greenfoot.*;  
import java.awt.Color;
import java.text.DecimalFormat;
/**
 * Write a description of class EnterTendered here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculate  extends Actor
{
private int decim = 0;
private String out;
public double last = 0.0;
private boolean activated = false;
private int level;

   public Calculate()
   {
       level = 1;
       update(0.0);
       getImage().setColor(new Color(0,0,0)); 
       
    }
    public void act() 
    {
       if(Greenfoot.mousePressed(this)) activate();
       else if(Greenfoot.mousePressed(null) && !Greenfoot.mousePressed(this)) deactivate();
       
    }    
    
   public void deactivate() 
    {
        activated = false;
        getImage().setTransparency(100); 
    }
    
   public void activate() 
    {
        activated = true;
        getImage().setTransparency(255);
        
        if(level == 1){
            level = 2;
            getWorld().removeObject(this);
            Greenfoot.setWorld(new EchoWorld(this));
        }
        else{
            level = 1;
        } 
    }
    
    public void update(double f)
    {
        out = "CALCULATE ";  
        
        
        setImage(new GreenfootImage((out.length() * 10 ) , 20 ));
        getImage().fill();
        BitFont.drawStringOn(getImage(), out, 10,10);
        
        
    }
}
