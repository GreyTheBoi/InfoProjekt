/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
class PartControllerModel implements Model
{
    Controller c;
    View v;
    LevelDatabase lvlDB;
    
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
    
    public String getString(String key, int ID){
        return "N/A";
    }
    
    public int getInt(int key, int ID){
        return -1;
    }
    
    /**
     * Constructor for objects of class PartControllerModel
     */
    PartControllerModel ()
    {
        
    }
}
