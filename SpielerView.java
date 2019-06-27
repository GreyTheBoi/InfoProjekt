/**
 * scrapped class [please look in LevelView for the Player]
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
class SpielerView implements View
{
    
    Controller c;
    
    String input;
    boolean keyPressed;
    
    //base funktionen
    public Controller getController(){
        return c;
    }

    public void setController(Controller nc){
        c = nc;
    }

    //getter für tasten input
    public String getWindowInput(){
        return input;
    }

    public boolean getKeyState(){
        return keyPressed;
    }
    
    /**
     * Constructor for objects of class SpielerView
     */
    SpielerView ()
    {
        
    }
    
    public int getTick(){
        return -1;
    }
    
    public void update(){
        
    }
    
}
