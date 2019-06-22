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

public class LevelView extends JFrame implements View, KeyListener, ActionListener {
    Controller c;

    public int PlayerX;
    public int PlayerY;

    public int vspeed;
    public int hspeed;
    private String input;
    private boolean keyPressed;

    private JPanel TimelineBackground;
    private JPanel TimelineFront;
    private JPanel player;
    private JButton keylistenObj; // >:| keine ahnung whyyyyyyyyyyyyyyy (bitte rausnehmen vor abgabe thx)

    Ticker t;
    int time = 0; //debug

    //Constructor 
    public LevelView(){

        PlayerX = 250;
        PlayerY = 200;

        vspeed = 0;
        hspeed = 0;

        input = "?";

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
        player.setFocusable(true);

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
        contentPane.add(TimelineBackground);
        contentPane.add(TimelineFront);
        contentPane.add(player);
        contentPane.add(keylistenObj);

        //adding panel to JFrame and seting of window position and close operation
        getContentPane().add(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        t = new Ticker(this, 20);
    }

    //base funktionen
    public Controller getController(){
        return c;
    }

    //controller setter
    public void setController(Controller nc){
        c = nc;
    }

    //getter für tasten input
    public String getWindowInput(){
        return input;
    }

    public boolean getKeyState(){
        return keyPressed;
    }

    //listeners and interaction
    public void actionPerformed(ActionEvent e) {
        // if(e.getSource() == this.listenerObj){
        // goal.setText(("got start"));
        // }
    }

    public void keyPressed(KeyEvent e) {  
        // goal.setText("Pressed" + e.getKeyChar()); 
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){ //escape
            dispose();
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){ //W
            //player.show();
            input = "W";
        }
        if(e.getKeyCode() == KeyEvent.VK_A){ //A
            //player.show();
            input = "A";
        }
        if(e.getKeyCode() == KeyEvent.VK_S){ //S
            //player.show();
            input = "S";
        }
        if(e.getKeyCode() == KeyEvent.VK_D){ //D
            //player.show();
            input = "D";
        }
        keyPressed = true;
    }  

    public void keyReleased(KeyEvent e) {  
        // goal.setText("Released" + e.getKeyChar());  
        if(e.getKeyCode() == KeyEvent.VK_W){ //W
            //player.show();
            input = "W";
        }
        if(e.getKeyCode() == KeyEvent.VK_A){ //A
            //player.show();
            input = "A";
        }
        if(e.getKeyCode() == KeyEvent.VK_S){ //S
            //player.show();
            input = "S";
        }
        if(e.getKeyCode() == KeyEvent.VK_D){ //D
            //player.show();
            input = "D";
        }
        keyPressed = false;
    }  

    public void keyTyped(KeyEvent e) {  
        // goal.setText("Typed" + e.getKeyChar()); 
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){ //escape
            dispose();
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_W){ //W
            //player.show();
            input = "W";
        }
        if(e.getKeyCode() == KeyEvent.VK_A){ //A
            //player.show();
            input = "A";
        }
        if(e.getKeyCode() == KeyEvent.VK_S){ //S
            //player.show();
            input = "S";
        }
        if(e.getKeyCode() == KeyEvent.VK_D){ //D
            //player.show();
            input = "D";
        }
        keyPressed = true;
    }  

    public void update(){        
        String input = getWindowInput();
        boolean ks = getKeyState();

        //speed = 0;

        if(ks == true){
            switch(input){
                case "W":
                vspeed = -10;
                break;
                case "A":
                hspeed = -10;
                break;
                case "S":
                vspeed = 10;
                break;
                case "D":
                hspeed = 10;
                break;
            }
        }
        else{
            if(vspeed != 0){
                vspeed = 0;
            }
            if(hspeed != 0){
                hspeed = 0;
            }
        }

        PlayerX += hspeed;
        PlayerY += vspeed;
        player.setLocation(PlayerX, PlayerY);

        time++;
        System.out.println("tick " + time);
    }

}