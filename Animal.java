import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An abstract class to set the requirements for a class to be an animal.
 * 
 * @author Bruce Gustin
 * @version ©2021.1.13
 */
public abstract class Animal extends Actor
{
    private final int FOOD_TO_BREED;
    private final int BREED_AGE;
    private final int BROOD;
    private final int LONGEVITY;
    private Animal animal;
    
    public Animal(int foodToBreed, int breedAge, int brood, int longevity)
    {
        FOOD_TO_BREED = foodToBreed;
        BREED_AGE = breedAge;
        BROOD = brood;
        LONGEVITY = (int) (longevity * (0.1 * Math.random() + 1));
    }
    
    protected abstract void seekFood();
    
    protected int eat(int fed, Class food)
    {
        if(isTouching(food))
        {
            fed++;
        }
        return fed;
    }
    
    protected void die(int age)
    {
        if(age > LONGEVITY || isTouching(Carnivore.class))
        {
            getWorld().removeObject(this);
        }
    }
    
    protected int parturition(int age, int fed, String animalType)
    {
        if(fed >= FOOD_TO_BREED && age > BREED_AGE)
        {
            for(int i = 0; i < BROOD; i++)
            {
                if(animalType.equals("Herbivore"))
                {
                    animal = new Herbivore();
                }
                else
                {
                    animal = new Carnivore();
                }
                getWorld().addObject(animal, getX() + 10, getY() + 10);
            }
            return 0;
        }
        else
        {
            return fed;
        }
    }
}
