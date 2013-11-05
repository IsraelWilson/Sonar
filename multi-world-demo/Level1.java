import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This is the whole scene. It creates and contains the objects that are in it.
 */
public class Level1 extends World
{
    public Level1()
    {    
        this (new Pengu());
    }
    
    public Level1(Pengu pengu)
    {    
        super(750, 500, 1);    // define size and resolution

        addObject ( new Ground(false), 85, 441);
        addObject ( new Ground(true), 665, 441);
        
        addObject ( new Cloud(), 369, 315 );
        
        addObject ( pengu, 66, 244 );
    }
}
