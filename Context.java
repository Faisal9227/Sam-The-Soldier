/**
 * Write a description of class Context here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Context
{
   private Bullets soldierBullet;
   public Context(){
    soldierBullet=null;
    }
    public void setState(Bullets soldierBullet){
       this.soldierBullet= soldierBullet;
    }
    public Bullets getState(){
        return soldierBullet;
    }
}
