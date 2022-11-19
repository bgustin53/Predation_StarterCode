import greenfoot.*;
import java.util.List;

/**
 * Carnivores eat herbivores
 * @author Bruce Gustin
 * @version ©2021.1.13
 */
public class Carnivore extends Animal
{
    // Carnivore Constants
    private final int SPEED = 2;
    private final int TURN_AT_EDGE = 90;
    private final int VISION_DISTANCE = 30;
    
    // Carnivore Variables/
    private int fed;
    private boolean preyInSight;
    private Actor prey;
    private int age;   
    
    // Constructs a new Carnivore
    public Carnivore()
    {
        //foodToBreed, breedAge, brood, longevity
        super(6, 300, 2, 2000);
        turn((int)(360 * Math.random()));
        move(30);
        fed = 0;
    }
 
    // Repeats
    public void act()
    {
        seekFood();
        fed = eat(fed, Herbivore.class);
        fed = parturition(age, fed, "Carnivore");
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

        int ordinalX = 0;
        int currentSignX = 1;
        int ordinalY = 0;
        int currentSignY = 1;
    
        for(int x = 0; x <= VISION_DISTANCE; x += ordinalX * currentSignX)
        {
            for(int y = 0; y <= VISION_DISTANCE; y += ordinalY * currentSignY)
            {
                prey = getOneObjectAtOffset(x, y, Herbivore.class);
                if(prey != null)
                {
                    turnTowards(prey.getX(), prey.getY());
                    break;
                }
                currentSignY *= -1;
                ordinalY++;
            }
            ordinalY = 0;
            currentSignY = 1;
            currentSignX *= -1;
            ordinalX++;
        }
    } 
}
