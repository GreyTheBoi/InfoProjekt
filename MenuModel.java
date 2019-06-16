
/**
 * Write a description of class MenuModel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuModel implements Model
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
     * Constructor for objects of class MenuModel
     */
    public MenuModel()
    {

    }

}
