
/**
 * Write a description of class TimelineView here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class TimelineView implements View
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
     * Constructor for objects of class TimelineView
     */
    TimelineView ()
    {
        
    }
}
