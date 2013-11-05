import greenfoot.*;  
import java.awt.Color;
/**
 * Write a description of class EnterTendered here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fahrenheit  extends Actor
{
private int decim = 0;
private String out;
public double last = 0.0;
private boolean activated = false;

   public Fahrenheit()
   {
       update(0.0);
       getImage().setColor(new Color(0,0,0)); 
       
    }
    public void act() 
    {
       if(activated) keyListen();
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
    }
    
    public void keyListen()
    {
        String gnirts = Greenfoot.getKey();

        if(gnirts != null && gnirts.length() == 1)
       {
     
      try{ if(decim == 0) last = (last * 10) +  Double.parseDouble(gnirts);
           else if(decim == 1) 
           {
               last += Double.parseDouble(gnirts)/10;
               decim = 2;
            }
            
           else last += Double.parseDouble(gnirts)/100;        
         }
       
        
      
      catch(java.lang.NumberFormatException e){ decim = 1; }    
      
       update(last);  
       }

    if(Greenfoot.isKeyDown("backspace")) 
    {
        last = 0.0;
        decim = 0;
        update(last);
    }
}
    
    public void update(double f)
    {
        out = "FAHRENHEIT " + f;  
        
        
        setImage(new GreenfootImage((out.length() * 10 ) , 20 ));
        getImage().fill();
        BitFont.drawStringOn(getImage(), out, 10,10);
        
        
    }
}
