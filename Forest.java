import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.util.List;

/**
 * Creates the world for predation events to occur and
 * to display population results
 * 
 * @author Bruce Gustin
 * @version ©2021.1.13
 */

public class Forest extends World
{
    // Forest Constants
    // add start plants
    // add start animals
    
    
    private final int STEP_REPORTING = 50;     // how often to add a data line
    private final int MAX_STEPS = 5000;        //number of lines of data collected in the data file
    
    // Creates fields for writing data
    private int step;                         

    
    // Object fields
    private Animal animal;
    private Plant plant;
    
    // Forest constructor
    public Forest() 
    {
        super(1200, 800, 1);
        prepareScene();
    }

    // Repeats
    public void act()
    {
        reportData();
        endSimulation();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepareScene()
    {     
       // add organism to scene at random locations
    }
    
    
    private void reportData()
    {
        step++;
        
        // Creates an array of items by type in the world 
        List PlantObjects = getObjects(Plant.class);
        List HerbivoreObjects = getObjects(Herbivore.class);        
        List CarnivoreObjects = getObjects(Carnivore.class);
        
        // Initializes the string containing the data to print to the console and data file
        if(step % STEP_REPORTING == 0)
        {
            String stepLine = "Step: " + step;
            String plantLine = "Plants: " + PlantObjects.size();
            String herbivoreLine = "Herbivore: " + HerbivoreObjects.size();
            String carnivoreLine = "Carnivore: " + CarnivoreObjects.size();
            
            // Prints data to console 
            System.out.print(stepLine + "\t" + plantLine + "\t" + herbivoreLine + "\t" +
                             carnivoreLine + "\n");

        }
    }  
    
    private void endSimulation() 
    {
        if(step > MAX_STEPS)
        {       
            System.out.println("End of simulation");
            Greenfoot.stop();
          
        }

    }
}
