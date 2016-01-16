import greenfoot.*;

/**
 * Write a description of class GameStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameStart extends World
{

    /**
     * Constructor for objects of class GameStart.
     * 
     */
    public GameStart()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        //getBackground().drawImage(new GreenfootImage("GameStart.jpeg"), 0, 0);
        Greenfoot.setWorld(this);
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new GameMenu());            
        }        
    }    
}