/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
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
