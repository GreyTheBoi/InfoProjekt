/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
public class MenuController implements Controller
{   
    //wird erst später verwendet
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
    
    public void update(){
       
    }

    /**
     * Constructor for objects of class MenuController
     */
    public MenuController()
    {
        
    }
}