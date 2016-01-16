import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Broker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Broker  
{
    // instance variables - replace the example below with your own
    private IMenu menuStore;
    /**
     * Constructor for objects of class Broker
     */
    public Broker(IMenu menuItem)
    {
        menuStore=menuItem;
    }
    public void execute(){
        menuStore.act1();
    }
}
