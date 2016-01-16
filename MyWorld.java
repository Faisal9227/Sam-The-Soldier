import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
   int counter=0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private String bgImageName;
    private double scrollSpeed;
    private int picWidth;
    Random randomGenerator = new Random();
    int max=2,min=1;
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    Score score=new Score();
    int scoreval;
    int powerupflag=0;
    int powermod=30;
    Platform platform;
    public MyWorld(String extention)
    {    
        super(1000, 400, 1,false);
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        bgImageName = "..\\Soldier\\images\\Background\\battle-greece."+extention;
        picWidth = (new GreenfootImage(bgImageName)).getWidth();
        scrollSpeed = 6;
        setBackground(bgImageName);
        Greenfoot.setSpeed(40);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
         Greenfoot.playSound("..\\sounds\\Start.wav");
        addObject(score, 880, 40);
        Soldier soldier=new Soldier();
        addObject(soldier,45,250);
        
    }
     public void start(){
       act();
    }
     public void act(){
        if(Greenfoot.isKeyDown("right")){ 
         counter++;
        }
         scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        if(Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("down")){
            paint(scrollPosition);
             if(counter % 125==0){
            platform=new Platform();
            addObject(platform,1000,250);
            
        }
        if(counter % 170==0){
            Hostage hostage=new Hostage();
            addObject(hostage,1000,250);
        }
        }
        if(counter % 30 == 0 && Greenfoot.isKeyDown("right") ){
          int random = randomGenerator.nextInt(4);
          if(random==1){
              EnemyFactory enemy=new Enemy1(1,-7,true,1,0,random,random);
                GreenfootImage enemyimage = enemy.getImage();
              addObject( enemy, getWidth(), 250);
              
            }
           else if(random==2){
               EnemyFactory enemy=new Enemy2(1,-8,true,1,0,random,random);
               GreenfootImage enemyimage = enemy.getImage();
              addObject( enemy, getWidth(), 250);
              
            }
             else if(random==3){
               EnemyFactory enemy=new Enemy2(1,-10,true,1,0,random,random);
               GreenfootImage enemyimage = enemy.getImage();
              addObject( enemy, getWidth(), 250);
              
            }
           
        }
       if(score.getScore() % powermod  == 0 && score.getScore() != 0 && getObjects(Powerup.class).size()==0){
          
               Powerup powerup=new Powerup();
            GreenfootImage enemyimage = powerup.getImage();
            addObject( powerup, getWidth(), 250);
             powermod++;
            if(powermod>=45){
            powermod=30;
            }
          Greenfoot.playSound("..\\sounds\\NoMercy.wav");
       }
    }
     private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }
    
}
