
/**
 * Write a description of class PlayerController here.
 *
 * @author Nikolas Grafwallner
 * @version (a version number or a date)
 */
public class PlayerController implements Controller
{
    View v;
    Model m;
    private boolean wPressed, aPressed, sPressed, dPressed;
    public int processInput(String i){
        // System.out.println("started process input @"+getClass()); //es war nur spam. 
        switch(i){
            case "w":
                // System.out.println("got w");
                return -10;
            case "a":
                // System.out.println("got a");
                return -10;
            case "s":
                // System.out.println("got s");
                return 10;
            case "d":
                // System.out.println("got d");
                return 10;
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
    
    public void update(){
       
    }
    
    /**
     * Constructor for objects of class LevelController
     */
    PlayerController ()
    {

    }
   
}
