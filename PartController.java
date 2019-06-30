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

    public void setView(View nv){
        v = nv;
    }

    public View getView(){
        return v;
    }

    /**
     * Constructor for objects of class PartController
     */
    PartController ()
    {

    }
}
