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

public class partPopup extends JFrame implements PartView, View {

    private JPanel particle;
    
    int partCount;
    Controller c;
    String input;
    
    private int death;
    private int delay;
    private int startX;
    private int startY;
    private int width;
    private int height;
    
    boolean collision;
    private int spd; //speed (in ms) 

    Ticker tick;
    int delta;
    int frame;

    //Constructor 
    public partPopup(JPanel contentPane, Controller nC, int nX, int nY, int w, int h, int nDelay, int maxOpacity,int nDeath){
        frame = 0;
        collision = false;

        c = nC;
        delta = c.getView().getTickDelta();
        
        death = 20;
        partCount = 1;
        input = "N/A";
        delay = nDelay;
        death = nDeath; //(default: 500ms)
        spd = 20; //(default:20ms)

        startX = nX;
        startY = nY;
        width = w;
        height = h;

        particle = new JPanel(null);
        particle.setLayout(new FlowLayout());
        particle.setBounds(startX,startY,width,height);
        particle.setBackground(new Color(255,255,255));
        particle.setForeground(new Color(255,255,255));
        particle.setEnabled(true);
        particle.setFont(new Font("sansserif",0,12));
        particle.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(particle);

        tick = new Ticker(this,delta);
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

    public boolean getCollision(){
        return collision;
    }

    public int getTick(){
        return frame;
    }

    public int getWidth(){return width;}

    public int getHeight(){return height;}

    public int getX(){return startX;}

    public int getY(){return startY;}

    public int getSpeed(){return spd;}

    public int getFrame(){return frame;}

    public void update(){
        particle.setVisible(true);
        frame = frame +  spd;
        if(frame <= (delay/2)){ //up
            double x;
            double y;
            y = (double)frame/delay;
            x = y * 255;
            particle.setBackground(new Color((int)x,(int)x,(int)x));
            // System.out.println(particle.getBackground());
            // System.out.println("up " + frame);
        }
        if(frame >= delay && frame <= delay+death){ //keep
            double x = frame-delay;
            double y = death;
            double z = (double)x/y;
            double result = width * z;
            
            particle.setSize((int)result, (int)result);
            //particle.setPreferredSize(new Dimension((int)result, (int)result));
            
            particle.setForeground(new Color(255,0,0));
            particle.setBackground(new Color(255,0,0));
            collision = true;
            // System.out.println(getSize());
            // System.out.println("x: "+x+" y: "+y+" z: "+z+" res: "+(int)result);
            // System.out.println("keep " + frame);
        }
        if(frame >= delay+death && frame <= delay+death*2){ //fade
            double x = frame-delay-death;
            double y = death;
            double z = (double)x/y;
            double result = 255-z*255;
            particle.setBackground(new Color((int)result,(int)result,(int)result)); // notiz: ICH HASSE DOUBLES IN JAVA
            collision = false;
            // System.out.println(particle.getBackground());
            // System.out.println("x "+x+" y "+y+" z "+z+" result "+(int)result);
        }
        if(frame == delay+death*2){
            // System.out.println("called out: " + getClass() + " at frame: "+frame);
            startX = startY = width = height = -20;
        }
        if(frame >= delay+death*2){
            startX = startY = width = height = -20;
            setVisible(false);
        }

        particle.setBounds(startX,startY,width,height);
    }

    public String getWindowInput(){
        return input;
    }

    public int getTickDelta(){
        return delta;
    }

    public JPanel getContentPaneObj(){
        return null;
    }
}
