import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.ArrayList;
/**
 * Write a description of class ShowChange here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Combinations  extends DecimalRounder
{
   
    private String combo;
    private double[] tests = {100.0,50.0,20.0,10.0,5.0,1.0,0.25,0.10,0.05,0.01}; 
    private int[] results; 
    private String[] names = {"HUNDREDS: ","FIFTIES: ","TWENTIES: ","TENS: ","FIVES: ","ONES: ","QUARTERS: ","DIMES :","NICKELS :","PENNIES :"}; 
  
    private int currentY = 26;
     
     
    private double used = 0.0;
    
    private String out;
    
    private boolean done = false;
    
    public Combinations()
    {
         getImage().setColor(new Color(0,0,0));
         results = new int[10];
         setImage(new GreenfootImage(560,280));
         getImage().fill();
     
    }
    public void act() 
    {

       
    }    
    
    public void count()
    {
        
        for(int f = 0; f < 10; f++)
        {
            results[f] = 0;   
        }
        

        int i = 0;
         
         while(i < 10)
       {

           if(used - tests[i] >= 0) 
           {
               results[i] += 1;
               used -= tests[i];   
               used = round(used);
            }
            
            else  
            {
                i++; 
            }
           
        }
    }
    
    public void write()
    {
        currentY = 26;
        
        for(int x = 0; x < 10; x++)
        {
            if(results[x] > 0) 
            {
            currentY += 26;
            BitFont.drawStringOn(getImage(), (names[x] + results[x]), 10 , currentY); 
         //   System.out.println("Writing...");
            }

        } 
    }
    
     public void update(double f)
    {
         used = f;
         getImage().fill();
          count();
 
         out = "CHANGE COMBINATION: ";
       BitFont.drawStringOn(getImage(), out, 10,10);
       write();
       
  
    }
}
