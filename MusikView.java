/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
class MusikView implements View
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
     * Constructor for objects of class MusikView
     */
    MusikView ()
    {
        
    }
    
    public void update(){
        
    }
    
}
