/**
 * 
 * Level controller mit Model/DB verbindung um objekte zu laden
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
        //ein Block voller Kopfschmerzen
        for(int i = 0; i < m.getSize() ; i++){//geht jede ID einzeln durch bis er auf ein Match stößt
            if (m.getInt("frame", i)==v.getTick()){//checkt nach ob ^ zutrifft
                // System.out.println("N O W\n\n\n\n\n\n\n\n\n\n\n");
                String type = m.getString("type", i); // schreibt den DB eintrag in eine variable damit er nicht immer aufgerufen wird
                switch(type){ //Die datenbank hat einen haufen an typen von objekten zur auswahl die ovneinander unterschieden werden müssen
                    case "err": //error/filler eintag SOLL NICHT VERWENDET WERDEN (AUßER FÜR ID -1)
                        addItemTest err;
                        err = new addItemTest(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i),m.getInt("death", i));
                        break;
                    case "ait":
                        addItemTest ait;
                        ait = new addItemTest(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i),m.getInt("death", i));
                        break;
                    case "aith":
                        addItemTestH aith;
                        aith = new addItemTestH(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i),m.getInt("death", i));
                        break;
                    case "pop":
                        partPopup pop;
                        pop = new partPopup(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i),m.getInt("death", i));
                        break;
                    case "bullet":
                        System.out.println("making bullet");
                        partBullet bullet;
                        bullet = new partBullet(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i),m.getInt("death", i));
                        break;
                    case "border":
                        System.out.println("making border");
                        partBorder border;
                        border = new partBorder(v.getContentPaneObj(),this,m.getInt("posX", i),m.getInt("posY", i),
                        m.getInt("width", i),m.getInt("height", i),m.getInt("delay", i),m.getInt("opacity", i),m.getInt("death", i));
                        break;
                    default: //gibt zurück falls die DATENBANK einen blödsinn von sich gibt
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
        //der bescheidene Konstruktor
        m = new LevelModel();
        m.setController(this);
        m.setView(v);
    }
}
