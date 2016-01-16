import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hostage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hostage extends Actor
{
     int HOSTAGE_SPEED = -6;
    /**
     * Act - do whatever the Hostage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("down")){
            setLocation( (int)(getX() + HOSTAGE_SPEED), getY());
           if(getX()>(getWorld().getWidth()-5)){
             getWorld().removeObject(this);
            }
        }    
        if(getOneIntersectingObject(Soldier.class) !=null){
           getWorld().getObjects(Score.class).get(0).setScore(25);
            getWorld().removeObject(this);
        }
    }    
}
