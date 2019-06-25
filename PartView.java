/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
class PartView implements PartViewInterface, View
{
    int death;
    int partCount;
    Controller c;
    String input;

    public int getDeath(){
        return death;
    }

    public int getPartCount(){
        return partCount;
    }

    public PartView getRef(){
        return this;
    }

    //base funktionen
    public Controller getController(){
        return c;
    }

    public void setController(Controller nc){
        c = nc;
    }

    //getter für tasten input
    public String getWindowInput(){
        return input;
    }

    /**
     * Constructor for objects of class PartView
     */
    PartView (int sDeath, int sPartCount)
    {
        death = sDeath;
        partCount = sPartCount;
    }
    
    public void update(){
        
    }
    
}
