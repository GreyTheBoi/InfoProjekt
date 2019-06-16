
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    }
}
