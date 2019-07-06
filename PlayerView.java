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

    public JPanel player;
    private JPanel contentPane;
    private LevelView level;

    /**
     * Constructor for objects of class PlayerView
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

        vspeed = 0;
        hspeed = 0;
        speed = 8;

        player = new JPanel(null);
        player.setBorder(BorderFactory.createEtchedBorder(1));
        player.setBounds(250,200,PlayerWidth, PlayerHeight);
        player.setBackground(new Color(255,255,255));
        player.setForeground(new Color(255,255,255));
        player.setEnabled(true);
        player.setFont(new Font("sansserif",0,12));
        player.setLocation(PlayerX,PlayerY);
        player.setVisible(true);
        player.setFocusable(true);

        contentPane.add(player);
    }
    
    public PlayerView(JPanel NcontentPane, LevelView nLevel, int nX, int nY, int nS)
    {
        contentPane = NcontentPane;
        level = nLevel;

        PlayerX = nX;
        PlayerY = nY;
        PlayerWidth = 20;
        PlayerHeight = 20; //Muss ein Quadrat sein

        vspeed = 0;
        hspeed = 0;
        speed = nS;

        player = new JPanel(null);
        player.setBorder(BorderFactory.createEtchedBorder(1));
        player.setBounds(250,200,PlayerWidth, PlayerHeight);
        player.setBackground(new Color(255,255,255));
        player.setForeground(new Color(255,255,255));
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
    
    public JPanel getContentPaneObj(){
        return null;
    }

}
