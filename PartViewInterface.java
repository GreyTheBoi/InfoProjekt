
/**
 * Write a description of interface PartViewInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

interface PartViewInterface
{
    int getDeath();

    int getPartCount();

    PartView getRef();

    //base funktionen
    Controller getController();

    void setController(Controller nc);
}
