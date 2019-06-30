/**
 * 
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
interface Controller
{
    int processInput(String input);
    
    void setModel(Model nm);
    Model getModel();
    
    void setView(View nv);
    View getView();
}
