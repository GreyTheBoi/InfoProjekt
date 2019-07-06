/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
class LevelController implements Controller
{
    View v;
    Model m;

    public int processInput(String i){
        return -1;
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

    // Nikolas Grafwallner
    public void update(){
        // if (m.getInt()
    }

    /**
     * Constructor for objects of class LevelController
     */
    LevelController ()
    {
        m = new LevelModel();
        m.setController(this);
        m.setView(v);
    }
}
