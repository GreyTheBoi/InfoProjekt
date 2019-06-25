/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */

interface PartView
{
    int getDeath();

    int getPartCount();

    //base funktionen
    Controller getController();

    void setController(Controller nc);
}