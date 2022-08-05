import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)
import java.util.List;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

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

    // Forest Fields
    private Animal animal;
    private Plant plant;
    
    // Fields for writing data
    private FileWriter myWriter;
    private int step;
    private boolean titlePrinted;
    private final int STEP_REPORTING = 50;
    private final int MAX_STEPS = 5000;
    
    // Forest constructor
    public Forest() 
    {
        super(1200, 800, 1);
        prepareScene();
        createDataFile();
    }

    // Repeats to data output
    public void act()
    {
        tableGraph();
        endSimulation();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepareScene()
    {
        
    }
        
    // Creates a new data file on use computer called data.txt
    private void createDataFile()
    {        
        try
        {
            myWriter = new FileWriter("data.txt");
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    //Displays data into the console and into the data file
    private void tableGraph()
    {
        step++;
        List PlantObjects = getObjects(Plant.class);
        List HerbivoreObjects = getObjects(Herbivore.class);        
        List CarnivoreObjects = getObjects(Carnivore.class);
        if(step % STEP_REPORTING == 0)
        {
            String stepLine = "Step: " + step;
            String plantLine = "Plants: " + PlantObjects.size();
            String herbivoreLine = "Herbivore: " + HerbivoreObjects.size();
            String carnivoreLine = "Carnivore: " + CarnivoreObjects.size();
            System.out.format("%15s%13s%16s%18s\n", stepLine, plantLine, herbivoreLine, carnivoreLine);
            String toPrint = "Step\tPlants(by 10s)\tHerbivores\tCarnivores\n";
            if(!titlePrinted)
            {
                titlePrinted = true;
            }
            else
            {
                toPrint = step + "\t" + PlantObjects.size()/10 + "\t" + HerbivoreObjects.size() + "\t" + CarnivoreObjects.size() + "\n";
            }
            try
            {
                myWriter.append(toPrint);
            } catch (IOException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }  
    
    private void endSimulation() 
    {
        if(step > MAX_STEPS)
        {       
            try
            {
                myWriter.close();
                System.out.println("End of simulation");
                Greenfoot.stop();
            } catch (IOException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}
