import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends EnemyFactory
{
    public Enemy2(int runvar,int ENEMY_SPEED,boolean isalive,int isalivevar,int counter,int enemyno,int health){
         setRunvar(runvar);
    	setENEMY_SPEED(ENEMY_SPEED);
    	setIsalive(isalive);
    	setIsalivevar(isalivevar);
    	setCounter(counter);
    	setEnemyno(enemyno);
    	setHealth(health);
    }
    
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     super.act();
    }    
}
