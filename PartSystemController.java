
/**
 * Write a description of class PartSystemController here.
 *
 * @author Nicolas Lisgaras
 * @version 30.06.19
 */
public class PartSystemController implements Controller
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

    /**
     * Constructor for objects of class PartSystemController
     */
    public PartSystemController()
    {

    }
    
}
