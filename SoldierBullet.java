import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoldierBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoldierBullet extends Actor implements Bullets
{
    int BULLET_SPEED=15;
    int damage=2;
    public void doAction(Context context){
    
    context.setState(this);
    act();
   }
    /**
     * Act - do whatever the SoldierBullet1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        setLocation( (int)(getX() + BULLET_SPEED), getY());
       if(getX()>(getWorld().getWidth()-15)){
         getWorld().removeObject(this);
        }
    }    
}
