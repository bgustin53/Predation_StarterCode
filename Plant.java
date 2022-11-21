import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An abstract class to establish all method for all plants
 * 
 * @author Bruce Gustin
 * @version ©2021.1.13
 */
public abstract class Plant extends Actor
{
    private final int SEEDS;
    private final int SEED_CYCLE;
    private final int LONGEVITY;
    
    public Plant(int seeds, int seedCycle, int longevity)
    { 
        SEEDS = seeds;
        SEED_CYCLE = (int) (seedCycle / (0.2 * Math.random() + 1));
        LONGEVITY = longevity * (int) (0.1 * Math.random() + 1);
    }
    
    protected void propagate(int age, Plant plant)
    {
        if(age % SEED_CYCLE == 0)
        {
            int seeds = (int) (SEEDS * Math.random());
            for(int i = 0; i < seeds; i++)
            {
                int x = getX() + (int)(120 * Math.random()) - 60;
                int y = getY() + (int)(120 * Math.random()) - 60;
                getWorld().addObject(plant, x, y);
 
            }
        }
    }
    
    protected void die(int age, Plant plant)
    {
        if(age > LONGEVITY || isTouching(Herbivore.class))
        {
            getWorld().removeObject(this);
        }
    }
}
