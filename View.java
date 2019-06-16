
/**
 * Write a description of interface View here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

interface View
{
    int getTick();
    int getPlayerX();
    int getPlayerY();
    String getWindowInput();
    
    //base funktionen
    Controller getController();
    Controller setController();
}
