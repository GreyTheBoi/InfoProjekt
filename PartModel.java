
/**
 * Write a description of class PartModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class PartModel implements Model
{
    Controller c;
    View v;
    
    public Controller getController(){
        return c;
    }

    public void setController(Controller nc){
        c = nc;
    }

    public View getView(){
        return v;
    }

    public void setView(View nv){
        v = nv;
    }
    
    /**
     * Constructor for objects of class PartModel
     */
    PartModel ()
    {
        
    }
}
