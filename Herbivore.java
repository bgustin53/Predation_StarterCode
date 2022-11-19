import greenfoot.*;

/**
 * Herbivores eat herbs are are eaten by Carnivores
 * @author Bruce Gustin
 * @version ©2021.1.13
 */
public class Herbivore extends Animal
{
    // Herbivore Constants
    private final int SPEED = 1;
    private final int MAX_TURN_RADIUS = 12;
    private final int TURN_AT_EDGE = 90;
    
    // Herbivore Variables
    private int fed;
    private int age;   
    
    public Herbivore()
    {
        //foodToBreed, breedAge, brood, longevity
        super(12, 220, 6, 1000);
        turn((int)(360 * Math.random()));
        fed = 0;
    }
 
    public void act()
    {
        seekFood();
        fed = eat(fed, Plant.class);
        fed = parturition(age, fed, "Herbivore");
        die(age);
        age++;
    }
    
    protected void seekFood()
    {
        move(SPEED);
        
        if(isAtEdge())
        {
            turn(TURN_AT_EDGE);
        }
        
        // rendomly turns every 5 updates
        if(age % 5 == 0)
        {
            // turn from -max turn radius to +max turn radius
            int turn = (int)(2 * Math.random() * MAX_TURN_RADIUS) - MAX_TURN_RADIUS;
            turn(turn);
        }
    }
}