import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ShowChange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShowChange  extends DecimalRounder
{
    private EnterTendered price;
    private EnterAmount amount;
    private Combinations combos;
    
    public double result = 0.0; 
    
    private String out = "";
    
    private boolean init = false;
    
    public ShowChange(EnterTendered x, EnterAmount y, Combinations z)
    {
         getImage().setColor(new Color(0,0,0));
         price = x;
         amount = y;
         combos = z;
         setImage(new GreenfootImage(40,42));
     
    }
    public void act() 
    {
      foopen();
      update();
    }    
    
    public void foopen()
    {
       
        getImage().fill();
        BitFont.drawStringOn(getImage(), out, 10,46);
        
        if(Greenfoot.mousePressed(this))  
        {
            
            if(result != 0)        combos.update(round(result));  
        }
    }
    
    
    
     public void update()
    {
        
       if(price.last >= 0.0 && amount.last >= 0.0) 
       {
           result = round(price.last - amount.last);
        }
       
       if(result >= 0.0) out = "CHANGE: " + result;
       else out = "CHANGE: NEGATIVE"; 
        
        
        setImage(new GreenfootImage((out.length() * 15 )+20 , 16+20 ));
        getImage().fill();
        BitFont.drawStringOn(getImage(), out, 10,10);
    
    }
}
