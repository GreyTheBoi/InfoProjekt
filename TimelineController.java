/**
 * 
 * der controller für timelineView (ist filler)
 * 
 * @author Nicolas Lisgaras, Nikolas Grafwallner 
 * @version 20.06.19
 * 
 */
class TimelineController implements Controller
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
    
    public void update(){
       
    }

    /**
     * Constructor for objects of class TimelineController
     */
    TimelineController ()
    {
        
    }
}
