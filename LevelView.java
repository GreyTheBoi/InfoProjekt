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
    Controller c;

    public int PlayerX;
    public int PlayerY;

    public int vspeed;
    public int hspeed;
    private String input;

    private boolean wPressed, aPressed, sPressed, dPressed;

    private JPanel TimelineBackground;
    private JPanel TimelineFront;
    private JPanel player;
    private JButton keylistenObj; // >:| keine ahnung whyyyyyyyyyyyyyyy (bitte rausnehmen vor abgabe thx)

    private Ticker ticker;

    //Constructor 
    public LevelView(){
        PlayerX = 250;
        PlayerY = 200;

        vspeed = 0;
        hspeed = 0;
        
        input = "N/A";

        wPressed = aPressed = sPressed = dPressed = false;

        setTitle("LevelView");
        setSize(500,400);

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
        player.setBounds(250,200,20,20);
        player.setBackground(new Color(255,255,255));
        player.setForeground(new Color(0,0,0));
        player.setEnabled(true);
        player.setFont(new Font("sansserif",0,12));
        player.setLocation(PlayerX,PlayerY);
        player.setVisible(true);
        player.addKeyListener(this);

        keylistenObj = new JButton("");
        keylistenObj.setBorder(BorderFactory.createEtchedBorder(1));
        keylistenObj.setBounds(250,200,20,20);
        keylistenObj.setBackground(new Color(0,0,0));
        keylistenObj.setForeground(new Color(0,0,0));
        keylistenObj.setEnabled(true);
        keylistenObj.setFont(new Font("sansserif",0,12));
        keylistenObj.setVisible(true);
        keylistenObj.addKeyListener(this);
        keylistenObj.setFocusable(true);

        //adding components to contentPane panel
        contentPane.add(player);
        contentPane.add(TimelineBackground);
        contentPane.add(TimelineFront);
        contentPane.add(keylistenObj);

        //adding panel to JFrame and seting of window position and close operation
        getContentPane().add(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        ticker = new Ticker(this, 200); //default: 20 ms

        System.out.println("E O C");
    }

    //base funktionen
    public Controller getController(){
        return c;
    }

    //controller setter
    public void setController(Controller nc){
        c = nc;
    }

    public String getWindowInput(){
        return input;
    }

    //listeners and interaction
    public void actionPerformed(ActionEvent e) {
        // if(e.getSource() == this.listenerObj){
        // goal.setText(("got start"));
        // }
    }

    public void keyPressed(KeyEvent e) {}  

    public void keyReleased(KeyEvent e) {  
        // goal.setText("Released" + e.getKeyChar());  
        if(e.getKeyCode() == KeyEvent.VK_W){ //W
            //player.show();
            wPressed = false;
            input = "N/A";
        }
        if(e.getKeyCode() == KeyEvent.VK_A){ //A
            //player.show();
            aPressed = false;
            input = "N/A";
        }
        if(e.getKeyCode() == KeyEvent.VK_S){ //S
            //player.show();
            sPressed = false;
            input = "N/A";
        }
        if(e.getKeyCode() == KeyEvent.VK_D){ //D
            //player.show();
            dPressed = false;
            input = "N/A";
        }
    }  

    public void keyTyped(KeyEvent e) {  
        // goal.setText("Typed" + e.getKeyChar()); 
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){ //escape
            dispose();
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){ //W
            //player.show();
            wPressed = true;
            input = "w";
        }
        if(e.getKeyCode() == KeyEvent.VK_A){ //A
            //player.show();
            aPressed = true;
            input = "a";
        }
        if(e.getKeyCode() == KeyEvent.VK_S){ //S
            //player.show();
            sPressed = true;
            input = "s";
        }
        if(e.getKeyCode() == KeyEvent.VK_D){ //D
            //player.show();
            dPressed = true;
            input = "d";
        }
    }  

    public void out(String output){
        System.out.println(output);
    }

    public void update(){        
        player.setVisible(true);

        if(wPressed == true){
            vspeed = -10;

        }
        else if(wPressed == false){
            vspeed = 0;
        }

        if(aPressed == true){
            hspeed = -10;
        }
        else if(aPressed == false){
            hspeed = 0;
        }

        if(sPressed == true){
            vspeed = 10;
        }
        else if(sPressed == false){
            vspeed = 0;
        }

        if(sPressed == true){
            hspeed = 10;
        }
        else if(sPressed == false){
            hspeed = 0;
        }

        PlayerX += hspeed;
        PlayerY += vspeed;
        player.setLocation(PlayerX, PlayerY);
    }
}