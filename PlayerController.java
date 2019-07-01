
/**
 * Write a description of class PlayerController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerController implements Controller
{
    View v;
    Model m;

    public int processInput(String i){
        System.out.println("started process input @"+getClass());
        switch(i){
            case "w":
                System.out.println("got w");
                return -10;
            default:
                return 0;
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
