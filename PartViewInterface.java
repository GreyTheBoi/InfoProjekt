/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
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
