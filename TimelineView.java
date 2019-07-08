import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;

/**
 * Timeline (external)
 * 
 * @author Nicolas Lisgaras, Nikolas Grafwallner
 * @version 20.06.19
 */
class TimelineView extends JFrame implements View
{

    Controller c;
    View level;

    String input;
    boolean keyPressed;
    int frame; // aktueller frame des levels
    int length; // länge des levels

    private JPanel TimelineBackground;
    private JPanel TimelineFront;

    /**
     * Constructor for objects of class TimelineView
     */
    TimelineView (JPanel contentPane, View v)
    {
        c = new TimelineController();
        level = v;
        length = 0;

        TimelineBackground = new JPanel(null);
        TimelineBackground.setBorder(BorderFactory.createEtchedBorder(1));
        TimelineBackground.setBounds(25,25,450,25);
        TimelineBackground.setBackground(new Color(216,28,131));
        TimelineBackground.setForeground(new Color(216,28,131));
        TimelineBackground.setEnabled(true);
        TimelineBackground.setFont(new Font("sansserif",0,12));
        TimelineBackground.setVisible(true);

        TimelineFront = new JPanel(null);
        TimelineFront.setBorder(BorderFactory.createEtchedBorder(1));
        TimelineFront.setBounds(25,25,450,25);
        TimelineFront.setBackground(new Color(255,255,255));
        TimelineFront.setForeground(new Color(255,255,255));
        TimelineFront.setEnabled(true);
        TimelineFront.setFont(new Font("sansserif",0,12));
        TimelineFront.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(TimelineBackground);
        contentPane.add(TimelineFront);

        this.setLocation(0, 0);
    }

    //base funktionen
    public Controller getController(){
        return c;
    }

    public void setController(Controller nc){
        c = nc;
    }

    //getter für tasten input
    public String getWindowInput(){
        return input;
    }
    
    public PlayerView getPlayer(){
        return null;
    }

    public boolean getKeyState(){
        return keyPressed;
    }

    public int processFrames(int frameRate, int length){
        int fps;
        fps = 1000/frameRate;
        return length*fps;
    }
    
    /**
     * berechnet wie die timeline sich ändern soll anhand der länge des songs
     */
    public void update(){
        length = processFrames(level.getTickDelta(), 194); //194 ist EIN FIXER WERT! soll variabel für andere songs in der zukunft sein Wird implementiert mit: Level2 tabelle
        frame = level.getTick();
        double ratio = (double)frame/length;
        double result = ratio * 450;
        TimelineBackground.setBounds(25,25,(int)result,25);
    }
    
    public int getTick(){
        return -1;
    }

    public int getTickDelta(){
        return -1;
    }

    public JPanel getContentPaneObj(){
        return null;
    }
}
