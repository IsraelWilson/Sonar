import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Register here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Register  extends World
{

    /**
     * Constructor for objects of class Register.
     * 
     */
    public Register()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(560, 560, 1); 
        EnterTendered price = new EnterTendered();
        EnterAmount amount = new EnterAmount();
        Combinations combos = new Combinations();
        addObject(price, 280, 80);
        addObject(amount, 280, 20);
        addObject(combos,280,420);
      
        addObject(new ShowChange(price, amount, combos), 280, 140); //showchange kinda runs the show
        Greenfoot.start(); //so you dont have to click "run" on greenfootgallery
    }
}
