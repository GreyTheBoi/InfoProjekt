/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
public class MenuController implements Controller
{
    View v;
    Model m;
    
    public void processInput(){
        
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
     * Constructor for objects of class MenuController
     */
    public MenuController()
    {
        
    }
}