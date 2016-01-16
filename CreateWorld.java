import greenfoot.*;
/**
 * Write a description of class CreateWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreateWorld
{
   // World a;
   public void selectInstructions(){
       Greenfoot.setWorld(new InstructionsPage());            
   }
   
    public void selectCredits(){
       Greenfoot.setWorld(new CreditsPage());            
   }
   public void selectPlay(){
       Greenfoot.setWorld(new SelectLevel());            
   }
}
