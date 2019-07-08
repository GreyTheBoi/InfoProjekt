/**
 * Model Interface
 * 
 * @author Nicolas Lisgaras, Nikolas Grafwallner
 * @version 20.06.19
 * 
 */

interface Model
{
    Controller getController();
    void setController(Controller nc);
    
    View getView();
    void setView(View nv);
    
    //Nikolas Grafwallner
    String getString(String key, int ID);
    //Nikolas Grafwallner
    int getInt(String key, int ID);
    int getSize();
}
