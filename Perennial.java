import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Herbs are what herbivores eat.
 * 
 * @author Bruce Gustin
 * @version ©2021.1.13
 */
public class Perennial extends Plant
{
    private int age;
    
    public Perennial()
    {
         //max seed per cycle, seed cycle, longevity
        super(60, 640, 3600);
    }
    
    /**
     * Act - do whatever the Herbs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        age++;
        propagate(age, new Perennial());
        die(age, this);
    } 
}
