import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyBullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullets extends Actor
{
    int BULLET_SPEED;
    public int getBULLET_SPEED() {
        return BULLET_SPEED;
    }
    public void setBULLET_SPEED(int BULLET_SPEED) {
        this.BULLET_SPEED = BULLET_SPEED;
    }
     public int getDamage() {
        return BULLET_SPEED;
    }
    public void setDamage(int damage) {
        this.BULLET_SPEED = BULLET_SPEED;
    }
    /**
     * Act - do whatever the EnemyBullets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation( (int)(getX() + BULLET_SPEED), getY());
       if(getX()<15){
         getWorld().removeObject(this);
        }
    }    
}
