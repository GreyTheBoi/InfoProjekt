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

    public void processInput(){
        
    }

    /**
     * Constructor for objects of class LevelController
     */
    LevelController ()
    {

    }
}
