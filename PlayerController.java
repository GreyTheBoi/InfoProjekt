
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
    private boolean wPressed, aPressed, sPressed, dPressed;
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
    
    public int getSpeedw(){
        if (wPressed = true){
            return 10;
        }
        return 0;
    }
    
    public int getSpeeda(){
        if (aPressed = true){
            return -10;
        }
        return 0;
    }
    
    public int getSpeeds(){
        if (sPressed = true){
            return -10;
        }
        return 0;
    }
    
    public int getSpeedd(){
        if (dPressed = true){
            return 10;
        }
        return 0;
    }
    
    /**
     * Constructor for objects of class LevelController
     */
    PlayerController ()
    {

    }
   
}
