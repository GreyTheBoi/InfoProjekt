/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */

interface View
{
    String getWindowInput();
    boolean getKeyState();
    
    //base funktionen
    Controller getController();
    void setController(Controller nc);
}
