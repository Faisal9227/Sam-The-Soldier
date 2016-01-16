import greenfoot.*;

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor implements IMenu
{
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    CreateWorld obj=new CreateWorld();
    public void act1() 
    {
            obj.selectPlay();// Add your action code here.
      }    
}
