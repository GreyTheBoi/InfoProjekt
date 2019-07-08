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
 * Text genereted by Simple GUI Extension for BlueJ
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */

public class LevelView extends JFrame implements View, KeyListener, ActionListener{
    Controller c; // controller
    addItemTest ait;

    public int hView;// fenster weite
    public int wView;// fenster höhe
    private String input;

    private boolean wPressed, aPressed, sPressed, dPressed;

    private JButton keylistenObj; // >:| keine ahnung whyyyyyyyyyyyyyyy (bitte rausnehmen vor abgabe thx)

    private Ticker ticker;
    private int tick;
    private AudioPlayer musik;
    //private MapDevHelper dh; //obsolete
    private MapDevHelper MapDevHelper;
    private TimelineView Timeline;
    public PlayerView Player;
    private JPanel contentPane;

    //Constructor 
    public LevelView(){
        hView = 400;
        wView = 500;

        input = "N/A";
        tick = 20;

        wPressed = aPressed = sPressed = dPressed = false;

        setTitle("LevelView");
        setSize(wView,hView);

        //pane with null layout
        contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(0,0,0));
        contentPane.addKeyListener(this);

        keylistenObj = new JButton("");
        keylistenObj.setBorder(BorderFactory.createEtchedBorder(1));
        keylistenObj.setBounds(-100,-100,20,20);
        keylistenObj.setBackground(new Color(0,255,0));
        keylistenObj.setForeground(new Color(0,0,0));
        keylistenObj.setEnabled(true);
        keylistenObj.setFont(new Font("sansserif",0,12));
        keylistenObj.setVisible(true);
        keylistenObj.addKeyListener(this);
        keylistenObj.setFocusable(true);

        //adding external components to contentPane panel
        MapDevHelper = new MapDevHelper(this);
        Timeline = new TimelineView(contentPane,this);
        Player = new PlayerView(contentPane,this);
        //ait = new addItemTest(contentPane,c, 200, 0, 10, hView, 2000, 255); //testing DO NOT UNCOMMENT

        //adding components to contentPane panel
        contentPane.add(keylistenObj);

        //adding panel to JFrame and seting of window position and close operation
        getContentPane().add(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        //external threads
        ticker = new Ticker(this, tick); //default: 20 ms
        musik = new AudioPlayer("dark_cat_irene.wav");
        musik.start();

        out("Player Stats:\nPlayerX: " + Player.PlayerX + "\tPlayerY: " + Player.PlayerY + "\nPlayer size: " + Player.PlayerHeight);
        System.out.println("E O C");
    }

    //base funktionen
    /**
     * Controller getter
     */
    public Controller getController(){
        return c;
    }

    //controller setter
    /**
     * Controller setter
     */
    public void setController(Controller nc){
        c = nc;
    }

    /**
     * input string getter
     */
    public String getWindowInput(){
        return input;
    }

    public int getTick(){
        return ticker.getTick();
    }

    //listeners and interaction
    public void actionPerformed(ActionEvent e) {
        // if(e.getSource() == this.listenerObj){
        // goal.setText(("got start"));
        // }
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){ //escape
            dispose();
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){ //W
            //player.show();
            wPressed = true;
            input = "w";
            // out("w pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_A){ //A
            //player.show();
            aPressed = true;
            input = "a";
            // out("a pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_S){ //S
            //player.show();
            sPressed = true;
            input = "s";
            // out("s pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_D){ //D
            //player.show();
            dPressed = true;
            input = "d";
            // out("d pressed");
        }
    }  

    public void keyTyped(KeyEvent e) {}  

    public void keyReleased(KeyEvent e) {  
        // goal.setText("Released" + e.getKeyChar());  
        if(e.getKeyCode() == KeyEvent.VK_W){ //W
            //player.show();
            wPressed = false;
            input = "N/A";
            // out("w released");
        }
        if(e.getKeyCode() == KeyEvent.VK_A){ //A
            //player.show();
            aPressed = false;
            input = "N/A";
            // out("a released");
        }
        if(e.getKeyCode() == KeyEvent.VK_S){ //S
            //player.show();
            sPressed = false;
            input = "N/A";
            // out("s released");
        }
        if(e.getKeyCode() == KeyEvent.VK_D){ //D
            //player.show();
            dPressed = false;
            input = "N/A";
            //out("d released");
        }
    }

    /**
     * kurz form der Output Fuktion
     */
    public void out(String output){
        System.out.println(output);
    }

    /**
     * Per tick (vom ticker) wird der Inhalt dieser Funktion ausgeführt
     */
    public void update(){        
        if(wPressed == true){
            Player.vspeed = Player.getController().processInput("w");
        }

        if(aPressed == true){
            Player.hspeed = Player.getController().processInput("a");
        }

        if(sPressed == true){
            Player.vspeed = Player.getController().processInput("s");
        }

        if(dPressed == true){
            Player.hspeed = Player.getController().processInput("d");
        }

        Player.update();
        Timeline.update();
        c.update();

    }

    public int getTickDelta(){
        return tick;//nicht verwirrt sein tick delta wird in int tick gespeiuchert und der aktuelle tick wird nicht gepeichert
    }
    
    public PlayerView getPlayer(){
        return Player;
    }

    public JPanel getContentPaneObj(){
        return contentPane;
    }

}