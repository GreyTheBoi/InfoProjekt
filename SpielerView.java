/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
class SpielerView implements View
{
    
    Controller c;
    
    //base funktionen
    public Controller getController(){
        return c;
    }

    public void setController(Controller nc){
        c = nc;
    }

    public String getWindowInput(){
        return "?";
    }
    
    /**
     * Constructor for objects of class SpielerView
     */
    SpielerView ()
    {
        
    }
}
