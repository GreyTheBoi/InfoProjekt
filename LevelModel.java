
/**
 * Write a description of class LevelModel here.
 * 
 * @author Nikolas Grafwallner, Nicolas Lisgaras
 * @version (a version number or a date)
 */
class LevelModel implements Model
{
    LevelDatabase lvlDB;

    Controller c;
    View v;

    /**
     * Constructor for objects of class LevelModel
     */
    LevelModel ()
    {
        lvlDB = new LevelDatabase();
    }

    public Controller getController(){
        return c;
    }

    public void setController(Controller nc){
        c = nc;
    }

    public View getView(){
        return v;
    }
    //Nikolas Grafwallner 
    public String getString(String key, int ID){
        return lvlDB.selectString(key,ID);
    }
    //Nikolas Grafwallner
    public int getInt(String key, int ID){
        return lvlDB.selectInt(key , ID);
    }
    
    public int getSize(){
        return lvlDB.getSize();
    }

    public void setView(View nv){
        v = nv;
    }    
}
