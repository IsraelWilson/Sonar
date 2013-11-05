import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * The ground.
 */
public class Ground extends Actor
{
    public Ground()
    {
    }
    
    public Ground(String image)
    {
        setImage(image);
    }
    
    public Ground(boolean flip)
    {
        if (flip) {
            getImage().mirrorHorizontally();
        }
    }
}
