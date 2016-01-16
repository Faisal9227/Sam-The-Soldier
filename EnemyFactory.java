import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class EnemyFactory extends Actor implements IscoreSubject
{
    IscoreObserver score;
    int runvar;
    int ENEMY_SPEED ;
    boolean isalive;
    int isalivevar;
    int counter;
    int enemyno;
    int flipcount=0;
    int health;
    boolean flip=false;
    int tempscore=0;
    int enemyboost=0;
    boolean s=true;
    public EnemyFactory(){
    setLocation( 45,250);
    }
    public void setRunvar(int runvar) {
        this.runvar = runvar;
    }
    public int getENEMY_SPEED() {
        return ENEMY_SPEED;
    }
    public void setENEMY_SPEED(int eNEMY_SPEED) {
        ENEMY_SPEED = eNEMY_SPEED;
    }
    public boolean isIsalive() {
        return isalive;
    }
    public void setIsalive(boolean isalive) {
        this.isalive = isalive;
    }
    public int getIsalivevar() {
        return isalivevar;
    }
    public void setIsalivevar(int isalivevar) {
        this.isalivevar = isalivevar;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public int getEnemyno() {
        return enemyno;
    }
    public void setEnemyno(int enemyno) {
        this.enemyno = enemyno;
    }
     public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        attach();
        if(Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("down")){
             enemyboost=-4;
            }
         else if(!Greenfoot.isKeyDown("right")){
             enemyboost=0;
            }
             if(getOneIntersectingObject(Soldier.class) !=null){
           getWorld().removeObject(this);
           isalive=false;
        }
        if(isalive){
            flipcount++;
         counter++;
        GreenfootImage image = getImage();
        if(flip){
         setImage(new GreenfootImage("..\\Soldier\\images\\Enemy\\Enemy"+enemyno+"Run"+runvar+".png"));
         GreenfootImage img = getImage();
            img.mirrorHorizontally();
            setImage(img);
           
        }
        else{
            setImage(new GreenfootImage("..\\Soldier\\images\\Enemy\\Enemy"+enemyno+"Run"+runvar+".png"));
            
        }
         if(runvar==7)
          {
              runvar=1;
              
            }
            ++runvar;
                setLocation( (int)(getX() + ENEMY_SPEED+enemyboost), getY());
        if(getOneIntersectingObject(Platform.class) !=null){
            ENEMY_SPEED=-ENEMY_SPEED;
            flip=!flip;
        }
        if((counter % (16-enemyno) == 0) && getWorld().getObjects(Soldier.class).get(0).getY()>=getY() && !flip){
            if(enemyno==1){
          Enemy1Bullet enemybullet=new Enemy1Bullet();
          Greenfoot.playSound("..\\sounds\\Enemy1Shot.wav");
          GreenfootImage enemyimage = enemybullet.getImage();
          getWorld().addObject( enemybullet, getX()-30, 220);
          tempscore=5;
        }
        else if(enemyno==2){
              Enemy2Bullet enemybullet=new Enemy2Bullet();
              GreenfootImage enemyimage = enemybullet.getImage();
              getWorld().addObject( enemybullet, getX()-30, 220);
              tempscore=10;
            }
        else if(enemyno==3){
              Enemy3Bullet enemybullet=new Enemy3Bullet();
              GreenfootImage enemyimage = enemybullet.getImage();
              getWorld().addObject( enemybullet, getX()-30, 220);  
              tempscore=20;
            }
        }
        
        if(getOneIntersectingObject(SoldierBullet.class) !=null){
             //Enemy1 Dies
            // Remove Bullet
                removeTouching(SoldierBullet.class);
                setImage(new GreenfootImage("..\\Soldier\\images\\Enemy\\Enemy"+enemyno+"Run"+runvar+".png"));
                health--;
                if(health<=0){
                    //getWorld().getObjects(Score.class).get(0).setScore(tempscore);
                    notify(tempscore);
                    isalive=false;
                }
                isalivevar=1;
            }
            else  if(getOneIntersectingObject(SoldierBullet1.class) !=null){
             //Enemy1 Dies
            // Remove Bullet
                removeTouching(SoldierBullet1.class);
                setImage(new GreenfootImage("..\\Soldier\\images\\Enemy\\Enemy"+enemyno+"Run"+runvar+".png"));
                health=health-2;
                if(health<=0){
                    //getWorld().getObjects(Score.class).get(0).setScore(tempscore);
                    notify(tempscore);
                    isalive=false;
                }
                isalivevar=1;
            }
        }
    else{
         GreenfootImage image = getImage();
         if(flip){
         setImage(new GreenfootImage("..\\Soldier\\images\\Enemy\\Enemy"+enemyno+"Dying"+isalivevar+".png"));
         GreenfootImage img = getImage();
            img.mirrorHorizontally();
            setImage(img);
        }
        else{
            setImage(new GreenfootImage("..\\Soldier\\images\\Enemy\\Enemy"+enemyno+"Dying"+isalivevar+".png"));
        }
          if(isalivevar==6)
          {
              getWorld().removeObject(this);
            }
         ++isalivevar;
        
    }
    }
     @Override
     public void attach(){         
         score=getWorld().getObjects(Score.class).get(0);//new Score();
         //getWorld().addObject((Score)score, 880, 40);
        }
     @Override
     public void dettach(){
        }
     @Override
     public void notify(int val){
        score.update(val);
        }
}
