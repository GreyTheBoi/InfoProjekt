/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */

interface View
{
    String getWindowInput();
    
    //base funktionen
    Controller getController();
    void setController(Controller nc);
}
