/**
 *Text genereted by Simple GUI Extension for BlueJ
 */
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
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

public class addItemTest extends JFrame implements PartView, View {

    private JPanel particle;

    int death;
    int partCount;
    Controller c;
    String input;
    
    int startX;
    int startY;
    int width;
    int height;

    //Constructor 
    public addItemTest(JPanel contentPane, Controller nC, int nX, int nY, int w, int h){

        c = nC;
        death = 20;
        partCount = 1;
        input = "N/A";
        
        startX = nX;
        startY = nY;
        width = w;
        height = h;

        particle = new JPanel(null);
        particle.setBounds(startX,startY,width,height);
        particle.setBackground(new Color(255,255,255));
        particle.setForeground(new Color(0,0,0));
        particle.setEnabled(true);
        particle.setFont(new Font("sansserif",0,12));
        particle.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(particle);
    }

    public int getDeath(){
        return death;
    }

    public int getPartCount(){
        return partCount;
    }

    //base funktionen
    public Controller getController(){
        return c;
    }

    public void setController(Controller nC){
        c = nC;
    }

    public void update(){
        
    }

    public String getWindowInput(){
        return input;
    }
}