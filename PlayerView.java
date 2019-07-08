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

public class PlayerView extends JFrame implements View{
    Controller c; // controller

    public int PlayerX;
    public int PlayerY;
    public int PlayerWidth;
    public int PlayerHeight;

    public int vspeed;
    public int hspeed;
    public int speed;

    public int HP;
    private boolean damaged;
    private boolean invincibility;
    private int tick;
    private int tickDelta;
    private int invFrames;

    public JPanel player;
    private JPanel contentPane;
    public LevelView level;

    /**
     * Constructor for objects of class PlayerView
     * 
     */
    public PlayerView(JPanel NcontentPane, LevelView nLevel)
    {
        contentPane = NcontentPane;
        level = nLevel;
        c = new PlayerController();

        PlayerX = 250;
        PlayerY = 200;
        PlayerWidth = 20;
        PlayerHeight = 20; //Muss ein Quadrat sein

        HP = 3;
        damaged = false;
        invincibility = false;
        tick = 0;
        tickDelta = 0;
        invFrames = 50;

        vspeed = 0;
        hspeed = 0;
        speed = 8;
        
        player = new JPanel(null);
        player.setBounds(250,200,PlayerWidth, PlayerHeight);
        player.setBackground(new Color(0,255,216));
        player.setForeground(new Color(0,255,216));
        player.setEnabled(true);
        player.setFont(new Font("sansserif",0,12));
        player.setLocation(PlayerX,PlayerY);
        player.setVisible(true);
        player.setFocusable(true);

        contentPane.add(player);
    }
    
    /**
     * @return gibt zurück ob der player verletzt wurde (1 frame true)
     */
    public void loseLife(){
        damaged = true;
    }
    
    /**
     * @return gibt zurück ob der player noch unverwundbar ist
     */
    public boolean getInvincible(){
        return invincibility;
    }
    
    public PlayerView(JPanel NcontentPane, LevelView nLevel, int nX, int nY, int nS)
    {
        contentPane = NcontentPane;
        level = nLevel;

        PlayerX = nX;
        PlayerY = nY;
        PlayerWidth = 20;
        PlayerHeight = 20; //Muss ein Quadrat sein

        HP = 3;
        damaged = false;
        tick = 0;
        tickDelta = 0;
        invFrames = 50;

        vspeed = 0;
        hspeed = 0;
        speed = nS;

        player = new JPanel(null);
        player.setBounds(250,200,PlayerWidth, PlayerHeight);
        player.setBackground(new Color(0,255,216));
        player.setForeground(new Color(0,255,216));
        player.setEnabled(true);
        player.setFont(new Font("sansserif",0,12));
        player.setLocation(PlayerX,PlayerY);
        player.setVisible(true);
        player.setFocusable(true);

        contentPane.add(player);
    }

    /**
     * Per tick (vom ticker) wird der Inhalt dieser Funktion ausgeführt
     */
    public void update(){ 
        player.repaint();

        tick ++;
        PlayerX += hspeed;
        PlayerY += vspeed;
        player.setLocation(PlayerX, PlayerY);

        if(PlayerX > level.wView - PlayerWidth){ PlayerX = level.wView - PlayerWidth;}
        if(PlayerY > level.hView - PlayerHeight){ PlayerY = level.hView - PlayerHeight;}
        if(PlayerX < 0){ PlayerX = 0;}
        if(PlayerY < 0){ PlayerY = 0;}

        player.setVisible(true);
        vspeed = 0;
        hspeed = 0;

        if(damaged == true){
            damaged = false;
            invincibility = true;
            tickDelta = tick;
            System.out.println("got damage");
            AudioPlayer dmgSound;
            dmgSound = new AudioPlayer("oof.wav");
            dmgSound.start();
        }
        if(invincibility == true && tick - tickDelta <= invFrames){
            player.setBackground(new Color(200,200,200));
            player.setForeground(new Color(200,200,200));
            //System.out.println("damage mode");
        }
        if(invincibility == true && tick - tickDelta >= invFrames){
            invincibility = false;
            tickDelta = 0;
            player.setBackground(new Color(0,255,216));
            player.setForeground(new Color(0,255,216));
            System.out.println("inv off");
        }

        if(HP <= 0){
            System.out.println("DIED\n\n\n\n\n\n\n\n\n\nDIED");
        }
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
        return "N/A";
    }

    public boolean getKeyState(){
        return false;
    }

    public int getTick(){
        return -1;
    }

    public int getTickDelta(){
        return -1;
    }

    public PlayerView getPlayer(){
        return this;
    }

    public JPanel getContentPaneObj(){
        return null;
    }

}
