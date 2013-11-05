import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.DecimalFormat;
/**
 * Write a description of class DecimalRounder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DecimalRounder  extends Actor
{
    public double round(double d) {
        	DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
}
}
