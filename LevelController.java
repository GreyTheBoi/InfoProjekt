/**
 * 
 * @author Nicolas Lisgaras, Nikolas Grafwallner 
 * @version 20.06.19
 * 
 */
class LevelController implements Controller
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

    // Nikolas Grafwallner
    public void update(){
        for(int i = 0; i < m.getSize() ; i++){
            if (m.getInt("frame", i)==v.getTick()){
                // System.out.println("N O W\n\n\n\n\n\n\n\n\n\n\n");
                String type = m.getString("type", i);
                switch(type){
                    case "err":
                        addItemTest err;
                        err = new addItemTest(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i));
                        break;
                    case "ait":
                        addItemTest ait;
                        ait = new addItemTest(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i));
                        break;
                    case "pop":
                        partPopup pop;
                        pop = new partPopup(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i));
                        break;
                    case "bullet":
                        System.out.println("making bullet");
                        partBullet bullet;
                        bullet = new partBullet(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i));
                        break;
                    case "border":
                        System.out.println("making border");
                        partBorder border;
                        border = new partBorder(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i));
                        break;
                    default:
                        System.out.println("error in Database couldn't find object " + type);
                }
            }
        }
    }

    /**
     * Constructor for objects of class LevelController
     */
    LevelController ()
    {
        m = new LevelModel();
        m.setController(this);
        m.setView(v);
    }
}
