import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class EnterPrice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnterAmount extends DecimalRounder
{

private String out;
//private String gnirts;
public double last = 0;
private boolean activated = false;

private int decim = 0;

   public EnterAmount()
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
      
       update(round(last));  
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
        out = "ITEM PRICE: " + f;
        
        setImage(new GreenfootImage((out.length() * 14 )+20 , 16+20 ));
        getImage().fill();
        BitFont.drawStringOn(getImage(), out, 10,10);
        
        
    }
}
