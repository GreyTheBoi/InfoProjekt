/**
 * 
 * Aktuell nicht benutzt wird aber für Spiel laden wichtig
 * 
 * @author Nicolas Lisgaras, Nikolas Grafwallner
 * @version 20.06.19
 * 
 */
public class MenuModel implements Model
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
    
    //Nikolas Grafwallner
    public String getString(String key, int ID){
        return "N/A";
    }
    
    //Nikolas Grafwallner
    public int getInt(String key, int ID){
        return -1;
    }
    
    public int getSize(){
        return -1;
    }

    /**
     * Constructor for objects of class MenuModel
     */
    public MenuModel()
    {

    }

}
