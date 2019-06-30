
/**
 * Write a description of class PlayerController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerController
{
    View v;
    Model m;

    public int processInput(String i){
        switch(i){
            case "w":
                return -10;
            default:
                return -1;
        }
    }
    
    public void setModel(Model nm){
        m = nm;
    }

    public Model getModel(){
        return m;
    }

    public void setView(View nv){
        v = nv;
    }

    public View getView(){
        return v;
    }
    
    /**
     * Constructor for objects of class LevelController
     */
    PlayerController ()
    {

    }
}
