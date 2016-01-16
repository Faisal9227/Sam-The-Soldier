import greenfoot.*;

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    int PLATFORM_SPEED = -6;
    int health=10;
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("down")){
        setLocation( (int)(getX() + PLATFORM_SPEED), getY());
       if(getX()>(getWorld().getWidth()-5)){
         getWorld().removeObject(this);
        }
    }    
     if(getOneIntersectingObject(Enemy1Bullet.class) !=null || getOneIntersectingObject(Enemy2Bullet.class) !=null || getOneIntersectingObject(Enemy3Bullet.class) !=null || getOneIntersectingObject(SoldierBullet.class) !=null || getOneIntersectingObject(SoldierBullet1.class) !=null){
           if(getOneIntersectingObject(Enemy1Bullet.class) !=null || getOneIntersectingObject(SoldierBullet.class) !=null){
               health--;
            }
             if(getOneIntersectingObject(Enemy2Bullet.class) !=null|| getOneIntersectingObject(SoldierBullet1.class) !=null){
               health=health-2;
            }
             if(getOneIntersectingObject(Enemy3Bullet.class) !=null){
               health=health-3;
            }
           removeTouching(EnemyBullets.class);
           removeTouching(SoldierBullet.class);
           removeTouching(SoldierBullet1.class);
        }
        if(health<=0){
            getWorld().removeObject(this);
        }
}
}