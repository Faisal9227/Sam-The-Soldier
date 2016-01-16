import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectLevel extends World
{

    /**
     * Constructor for objects of class SelectLevel.
     * 
     */
    public SelectLevel()
    {    
         // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        //getBackground().drawImage(new GreenfootImage("frontpage.jpg"), 0, 0);
        
        addObject(new BeachWorld(),155,300);
        addObject(new DesertWorld(), 875, 300); 
    }
}
