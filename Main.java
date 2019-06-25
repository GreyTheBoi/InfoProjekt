/**
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
class Main
{
    View v;
    Model m;
    Controller c;
    /**
     * Constructor for objects of class Main
     */
    Main ()
    {
        c = new MenuController();
        v = new TitelbildschirmView();
        m = new MenuModel();
        
        c.setModel(m);
        c.setView(v);
        v.setController(c);
        m.setController(c);
        m.setView(v);
    }
}
