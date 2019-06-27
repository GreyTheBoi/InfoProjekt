/**
 *Text genereted by Simple GUI Extension for BlueJ
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */
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

public class LevelView extends JFrame implements View, KeyListener, ActionListener{
    Controller c; // controller
    addItemTest ait;

    private int PlayerX;
    private int PlayerY;
    private int PlayerWidth;
    private int PlayerHeight;
    private int hView;// fenster weite
    private int wView;// fenster höhe

    private int vspeed;
    private int hspeed;
    private int speed;
    private String input;

    private boolean wPressed, aPressed, sPressed, dPressed;

    private JPanel TimelineBackground;
    private JPanel TimelineFront;
    private JPanel player;
    private JButton keylistenObj; // >:| keine ahnung whyyyyyyyyyyyyyyy (bitte rausnehmen vor abgabe thx)

    private Ticker ticker;
    private AudioPlayer musik;
    //private MapDevHelper dh; //obsolete
    private MapDevHelper MapDevHelper;

    //Constructor 
    public LevelView(){
        PlayerX = 250;
        PlayerY = 200;
        hView = 400;
        wView = 500;
        PlayerWidth = 20;
        PlayerHeight = 20; //Muss ein Quadrat sein

        vspeed = 0;
        hspeed = 0;
        speed = 8;

        input = "N/A";

        wPressed = aPressed = sPressed = dPressed = false;

        setTitle("LevelView");
        setSize(wView,hView);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(0,0,0));
        contentPane.addKeyListener(this);

        TimelineBackground = new JPanel(null);
        TimelineBackground.setBorder(BorderFactory.createEtchedBorder(1));
        TimelineBackground.setBounds(25,25,450,25);
        TimelineBackground.setBackground(new Color(255,255,255));
        TimelineBackground.setForeground(new Color(255,255,255));
        TimelineBackground.setEnabled(true);
        TimelineBackground.setFont(new Font("sansserif",0,12));
        TimelineBackground.setVisible(true);
        TimelineBackground.addKeyListener(this);

        TimelineFront = new JPanel(null);
        TimelineFront.setBorder(BorderFactory.createEtchedBorder(1));
        TimelineFront.setBounds(25,25,450,25);
        TimelineFront.setBackground(new Color(216,28,131));
        TimelineFront.setForeground(new Color(0,0,0));
        TimelineFront.setEnabled(true);
        TimelineFront.setFont(new Font("sansserif",0,12));
        TimelineFront.setVisible(true);
        TimelineFront.addKeyListener(this);

        player = new JPanel(null);
        player.setBorder(BorderFactory.createEtchedBorder(1));
        player.setBounds(250,200,PlayerWidth, PlayerHeight);
        player.setBackground(new Color(255,255,255));
        player.setForeground(new Color(255,255,255));
        player.setEnabled(true);
        player.setFont(new Font("sansserif",0,12));
        player.setLocation(PlayerX,PlayerY);
        player.setVisible(true);
        player.addKeyListener(this);
        player.setFocusable(true);

        keylistenObj = new JButton("");
        keylistenObj.setBorder(BorderFactory.createEtchedBorder(1));
        keylistenObj.setBounds(-100,-100,20,20);
        keylistenObj.setBackground(new Color(0,0,0));
        keylistenObj.setForeground(new Color(0,0,0));
        keylistenObj.setEnabled(true);
        keylistenObj.setFont(new Font("sansserif",0,12));
        keylistenObj.setVisible(true);
        keylistenObj.addKeyListener(this);
        keylistenObj.setFocusable(true);

        //adding external components to contentPane panel
        ait = new addItemTest(contentPane,c, 200, 0, 10, hView, 2000, 125);
        //dh = new MapDevHelper(contentPane,c,this);
        
        //adding components to contentPane panel
        contentPane.add(TimelineBackground);
        contentPane.add(TimelineFront);
        contentPane.add(keylistenObj);
        contentPane.add(player);

        //adding panel to JFrame and seting of window position and close operation
        getContentPane().add(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        ticker = new Ticker(this, 20); //default: 20 ms
        musik = new AudioPlayer("dark_cat_irene.wav");
        musik.start();
        MapDevHelper = new MapDevHelper(this);

        out("Player Stats:\nPlayerX: " + PlayerX + "\tPlayerY: " + PlayerY + "\nPlayer size: " + PlayerHeight);
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
        player.setVisible(true);
        vspeed = 0;
        hspeed = 0;

        if(wPressed == true){
            vspeed = -speed;
        }

        if(aPressed == true){
            hspeed = -speed;
        }

        if(sPressed == true){
            vspeed = speed;
        }

        if(dPressed == true){
            hspeed = speed;
        }

        PlayerX += hspeed;
        PlayerY += vspeed;
        player.setLocation(PlayerX, PlayerY);

        if(PlayerX > wView - PlayerWidth){ PlayerX = wView - PlayerWidth;}
        if(PlayerY > hView - PlayerHeight){ PlayerY = hView - PlayerHeight;}
        if(PlayerX < 0){ PlayerX = 0;}
        if(PlayerY < 0){ PlayerY = 0;}
    }
}