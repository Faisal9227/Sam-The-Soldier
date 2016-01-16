import greenfoot.*;

/**
 * Write a description of class GameMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameMenu extends World
{

    /**
     * Constructor for objects of class GameMenu.
     * 
     */
    Broker broker1=new Broker(new PlayButton());
    Broker broker2=new Broker(new CreditsButton());
    Broker broker3=new Broker(new InstructionsButton());
    public GameMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        //getBackground().drawImage(new GreenfootImage("frontpage.jpg"), 0, 0);
        
        addObject(new PlayButton(),475,275);
        addObject(new CreditsButton(), 475, 375);
        addObject(new InstructionsButton(), 475, 475);
        
    }
    public void act(){
        if(Greenfoot.mouseClicked(getObjects(CreditsButton.class).get(0))){
            broker2.execute();
        } else if(Greenfoot.mouseClicked(getObjects(InstructionsButton.class).get(0))){
            broker3.execute();
        }else if(Greenfoot.mouseClicked(getObjects(PlayButton.class).get(0))){
            broker1.execute();
        }
        
    }
}