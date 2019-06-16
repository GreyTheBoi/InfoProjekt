
/**
 * Write a description of class SpielerController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
class SpielerController implements Controller
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

    /**
     * Constructor for objects of class SpielerController
     */
    SpielerController ()
    {

    }
}
