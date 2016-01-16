import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeachWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeachWorld extends Actor
{
    /**
     * Act - do whatever the BeachWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new MyWorld("jpg"));// Add your action code here.
        }
    }    
}
