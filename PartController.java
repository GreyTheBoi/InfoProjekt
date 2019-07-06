/**
 * Controller for all particels specifically
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
class PartController implements Controller
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

    /**
     * View setter
     * @param neuen view
     */
    public void setView(View nv){
        v = nv;
    }

    /**
     * View getter
     */
    public View getView(){
        return v;
    }
    
    public void update(){
       
    }

    /**
     * Constructor for objects of class PartController
     */
    PartController ()
    {

    }
}
