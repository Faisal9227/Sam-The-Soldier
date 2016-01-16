import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldier extends Actor implements ISubject
{
    IObserver hbar;//=new HealthBar("Player 1", "Health Points", 100, 100);
    //HealthBar hbar=new HealthBar("Player 1", "Health Points", 100, 100);
    int jumpvar=1;
    int jumpflag=0;
    double dy=1;
    boolean onPlatform=false;
    double gravity=8;
    int JUMP_HEIGHT=8;
    int runvar=1;
    int groundLevel = 250;
    boolean isalive=true;
    int isalivevar=1;
    int health=100;
    int lives=3;
    int powerup=0;
    boolean s=true;
    public Soldier(){
    
    }
    /**
     * Act - do whatever the Soldier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   /* public void addHealthBar(){
        getWorld().addObject(hbar, 250, 40);
    }*/
    public void act() 
    {
        if(s){
        attach();
        s=false;
        }
        boolean onGround = (getY() == 250);
        if(isalive){
            if(getOneIntersectingObject(Powerup.class) !=null && isalive){
                 powerup=1;
                }
            if(getOneIntersectingObject(Enemy1Bullet.class) !=null || getOneIntersectingObject(Enemy2Bullet.class) !=null || getOneIntersectingObject(Enemy3Bullet.class) !=null && isalive){
           if(getOneIntersectingObject(Enemy1Bullet.class) !=null){
               health--;
               notify(-1);         
            }
             if(getOneIntersectingObject(Enemy2Bullet.class) !=null){
               health=health-5;
               notify(-5);
            }
             if(getOneIntersectingObject(Enemy3Bullet.class) !=null){
               health=health-10;
               notify(-10);
            }
           removeTouching(EnemyBullets.class);
           if(health<=0){
            lives--;
            powerup=0;
            notify(100);
            isalive=false;
            health=100;
            }
            if(lives<=0){
             displayGameOver();
            }
        }
         if(onGround && isalive){
                onPlatform=false;
            }
             
            if(getOneIntersectingObject(Platform.class) !=null && isalive){
            onPlatform=true;
            onGround=false;
            setLocation(getX(),155);
            jumpflag=0;
            setImage(new GreenfootImage("..\\Soldier\\images\\Soldier\\Soldier.png"));
        }
            if(getOneIntersectingObject(EnemyFactory.class) !=null && isalive){
             lives--;
             powerup=0;
             health=100;
             notify(100);
             isalive=false;
             if(lives<=0){
                 displayGameOver();
                }
            }
           /* else if(getOneIntersectingObject(Enemy2.class) !=null){
            displayGameOver();
            }*/
            if(Greenfoot.isKeyDown("right") && (onGround||onPlatform) && isalive){
              setImage(new GreenfootImage("..\\Soldier\\images\\Soldier\\Run-"+runvar+".png"));
              if(runvar==6)
              {
                  runvar=1;
                }
                ++runvar;
            }
            else if(!Greenfoot.isKeyDown("right") && jumpflag==0 && isalive){
                setImage(new GreenfootImage("..\\Soldier\\images\\Soldier\\Soldier.png"));
            } 
           if (onGround && jumpflag==0 && isalive){
             if(Greenfoot.isKeyDown("up") && onGround){
                dy = -JUMP_HEIGHT;
                setImage(new GreenfootImage("..\\Soldier\\images\\Soldier\\Jump-1.png"));
                Greenfoot.playSound("..\\sounds\\Jump.wav");
                jumpflag=1;
            }
            }
           else if (!onGround && jumpflag==0 && isalive){
                drop();
            }
            if (jumpflag==1 && isalive){
                setLocation( getX(), (int)(getY() + dy) );
                if(getY()<150){
                    jumpflag=0;
                }
            }
            if(Greenfoot.isKeyDown("down") && isalive && !onPlatform){
              // show sitting
              setLocation( getX(), 270);
               setImage(new GreenfootImage("..\\Soldier\\images\\Soldier\\Sit-3.png"));
               jumpflag=0;
            }
             if(Greenfoot.isKeyDown("space") && isalive){
              // show running
            }
             if(getWorld().getObjects(Powerup.class).size()==1 ){
                 if(getOneIntersectingObject(Powerup.class) !=null && isalive){
                getWorld().removeObject(getWorld().getObjects(Powerup.class).get(0));
                }
            }
           
             if(Greenfoot.isKeyDown("control") && isalive && getWorld().getObjects(SoldierBullet.class).size()<10){
            if(powerup==0 && getWorld(). getObjects(SoldierBullet.class).size()<3 ){
                  Context context=new Context();
                  SoldierBullet soldierbullet=new SoldierBullet();
                  Greenfoot.playSound("..\\sounds\\SoldierShot.wav");
                  getWorld().addObject(soldierbullet,(int)(45+getImage().getWidth()/2),getY()-15);
                  soldierbullet.doAction(context);
                }
            else if(powerup==1 &&  getWorld().getObjects(SoldierBullet1.class).size()<3){
                 Context context=new Context();
                  SoldierBullet1 soldierbullet=new SoldierBullet1();
                  Greenfoot.playSound("..\\sounds\\SoldierShot.wav");
                  getWorld().addObject(soldierbullet,(int)(45+getImage().getWidth()/2),getY()-15);
                  soldierbullet.doAction(context);
            }
            }
             if(getOneIntersectingObject(Hostage.class) !=null && isalive){
                notify(5);
            }
        }
         else if(!isalive){
            dieanimation();
            }           
        }
    
    private void displayGameOver(){
        Greenfoot.playSound("..\\sounds\\GameOver.wav");
        GameOver gameover=new GameOver();
        getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
        getWorld().removeObject(this);
        Greenfoot.stop();      
        }
    public void drop(){
        if(getY()<=250){
                    setLocation( getX(), (int)(getY() + gravity) );
                    setImage(new GreenfootImage("..\\Soldier\\images\\Soldier\\Jump-3.png"));
                    jumpflag=0;
                }
                else if(getY()>250){
                   setLocation( getX(), 250 );
                   setImage(new GreenfootImage("..\\Soldier\\images\\Soldier\\Jump-5.png"));
                    jumpflag=0;
                }
    }
     private void dieanimation(){
         
        if(isalivevar==5){
            Greenfoot.delay(3);
            isalivevar=1;
            isalive=true;
        }
        setImage(new GreenfootImage("..\\Soldier\\images\\Soldier\\SoldierDying"+isalivevar+".png"));
        isalivevar++;
        }
     @Override
     public void attach(){
         hbar=new HealthBar("Player 1", "Health Points", 100, 100);
         getWorld().addObject((HealthBar)hbar, 250, 40);
        }
     @Override
     public void dettach(){
        }
     @Override
     public void notify(int val){
         //hbar.subtract(val);
         
         if(val==100){
             hbar.setValuee(100);
            }
         else{
             hbar.update(val);
            }
        }
   }
