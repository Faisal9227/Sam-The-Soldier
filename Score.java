import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor implements IscoreObserver
{
    int scoretemp;
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Score(){
        GreenfootImage newImage=new GreenfootImage(90,50);
        setImage(newImage);  
    }
    public void setScore(int score){
        scoretemp=scoretemp+score;
        GreenfootImage newImage =getImage();
        newImage.clear();
        newImage.setColor(Color.white);
        Font f=new Font("Cooper Black",Font.PLAIN,30);
        newImage.setFont(f);
        newImage.drawString(""+scoretemp,25,20);
    }
    public int getScore(){
        return scoretemp;
    }
    @Override
    public void update(int val){ setScore(val); }
    
}