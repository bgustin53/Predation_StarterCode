import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Herbs are what herbivores eat.
 * 
 * @author Bruce Gustin
 * @version ©2021.1.13
 */
public class Annual extends Plant
{
    private int age;
    
    public Annual()
    {
        //max seed per cycle, seed cycle, longevity
        super(120, 640, 700);
    }
    
    /**
     * Act - do whatever the Herbs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        age++;
        propagate(age, new Annual());
        die(age, this);
    }   

}
