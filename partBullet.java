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

public class partBullet extends JFrame implements PartView, View {

    private JPanel particle;
    private JPanel indicator;
    private JPanel contentPane;

    int death;
    int partCount;
    Controller c;
    String input;
    int delay;
    boolean collision;

    private int startX;
    private int startY;
    private int width;
    private int height;
    private int spd; //speed (in ms) 
    private int dir;

    Ticker tick;
    int delta;
    int frame;

    //Constructor 
    public partBullet(JPanel nContentPane, Controller nC, int nX, int nY, int w, int h, int nDelay, int maxOpacity){
        frame = 0;
        collision = false;

        contentPane = nContentPane;

        c = nC;
        dir = maxOpacity;

        delta = c.getView().getTickDelta();

        partCount = 1;
        input = "N/A";
        delay = nDelay;
        death = 500; //(default: 1000ms)
        spd = 20; //(default:20ms)

        startX = nX;
        startY = nY;
        width = w;
        height = h;

        indicator = new JPanel();
        indicator.setBounds(startX,startY,498,height);
        indicator.setBackground(new Color(64,64,64));
        indicator.setForeground(new Color(64,64,64));
        indicator.setEnabled(true);
        indicator.setFont(new Font("sansserif",0,12));
        // indicator.setOpaque(true);
        indicator.setVisible(true);

        particle = new JPanel();
        particle.setBounds(500+startX,startY,height,height);
        particle.setBackground(new Color(255,255,255));
        particle.setForeground(new Color(255,255,255));
        particle.setEnabled(true);
        particle.setFont(new Font("sansserif",0,12));
        // particle.setOpaque(true);
        particle.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(indicator);
        contentPane.add(particle);

        // System.out.println("BULLETZ\n\n\n\n\n\n\n\n\n\n");

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
        if(frame <= delay){
            indicator.setVisible(true);
            indicator.repaint();
        }
        if(frame <= delay+death*2){
            particle.setVisible(true);
            particle.repaint();
        }

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
            indicator.setVisible(false);
            if(dir<=1){
                double x = frame-delay;
                double y = death;
                double z = (double)x/y;
                double result = 600-(z*600+height);

                particle.setLocation((int)result*width,startY);
            }
            else{
                double x = frame-delay;
                double y = death;
                double z = (double)x/y;
                double result = 0+(z*600+height);

                particle.setLocation((int)result*width,startY);
            }

            particle.setForeground(new Color(255,0,0));
            particle.setBackground(new Color(255,0,0));
            collision = true;

            // System.out.println(particle.getBackground());
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
            indicator.setVisible(false);
            particle.setVisible(false);
        } 
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
