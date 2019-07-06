
/**
 * Write a description of class LevelModel here.
 * 
 * @author (your name) 
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

    public String getString(String key, int ID){
        return lvlDB.selectString(key,ID);
    }
    
    public int getInt(int key, int ID){
        return lvlDB.selectInt(Integer.toString(key) , ID);
    }

    public void setView(View nv){
        v = nv;
    }    
}
