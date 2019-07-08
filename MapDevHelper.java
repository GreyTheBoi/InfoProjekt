/**
 * 
 *  Level making tool um Frames zu markeieren miot space und auszugeben mit enter 
 *  DIESE KLASSE ENTHÄLT EINE LISTE >:)
 * 
 * @author Nicolas Lisgaras 
 * @version 27.06.19
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

import java.util.List;
import java.util.ArrayList;

public class MapDevHelper extends JFrame implements KeyListener{
    Controller c;
    View v;

    JButton keylistener;
    String input;

    List frames;

    //Constructor 
    public MapDevHelper(View nv){

        v = nv;

        setTitle("MapDevHelper");
        setSize(100,100);
        setLocation(0,0);

        frames = new ArrayList();

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(100,100));
        contentPane.setBackground(new Color(192,192,192));

        keylistener = new JButton();
        keylistener.setBounds(117,130,90,35);
        keylistener.setBackground(new Color(214,217,223));
        keylistener.setForeground(new Color(0,0,0));
        keylistener.setEnabled(true);
        keylistener.setFont(new Font("sansserif",0,12));
        keylistener.setText("Button1");
        keylistener.addKeyListener(this);
        keylistener.setFocusable(true);
        keylistener.setVisible(true);

        //adding components to contentPane panel
        //adding panel to JFrame and seting of window position and close operation
        getContentPane().add(contentPane);
        contentPane.add(keylistener);
        contentPane.addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){ //LEERTASTE
            //player.show();
            frames.add(Integer.toString(v.getTick()));
            System.out.println(Integer.toString(v.getTick()));
            // out("w released");
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            out();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {

    }  

    void out(){
        for(int i=0;i<frames.size();i++){
            System.out.println("Action" + i + " :\t" + frames.get(i));
        }
    }

}