
/**
 * Write a description of interface PartViewInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

interface PartViewInterface extends View
{
    int getDeath();
    int getPartCount();
    PartView getRef();
    
    //base funktionen
    Controller getController();
    Controller setController();
}
