/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */

interface Model
{
    Controller getController();
    void setController(Controller nc);
    
    View getView();
    void setView(View nv);
    
    String getString(String key, int ID);
    int getInt(int key, int ID);
}
