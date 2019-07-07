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

public class partBorder extends JFrame implements PartView, View {

    private JPanel upperBorder;
    private JPanel lowerBorder;
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
    private int ori;

    Ticker tick;
    int delta;
    int frame;
    int beat;

    //Constructor 
    public partBorder(JPanel nContentPane, Controller nC, int nX, int nY, int w, int h, int nDelay, int maxOpacity){
        frame = 0;
        collision = false;

        contentPane = nContentPane;

        c = nC;
        ori = maxOpacity;

        delta = c.getView().getTickDelta();
        
        partCount = 1;
        input = "N/A";
        delay = nDelay;
        death = 5000; //(default: 1000ms)
        spd = 20; //(default:20ms)

        startX = nX;
        startY = nY;
        width = w;
        height = h;
        
        lowerBorder = new JPanel();
        lowerBorder.setBounds(0,400-h,500,400);
        lowerBorder.setBackground(new Color(64,64,64));
        lowerBorder.setForeground(new Color(64,64,64));
        lowerBorder.setEnabled(true);
        lowerBorder.setFont(new Font("sansserif",0,12));
        // lowerBorder.setOpaque(true);
        lowerBorder.setVisible(true);

        upperBorder = new JPanel();
        upperBorder.setBounds(0,0,500,h);
        upperBorder.setBackground(new Color(64,64,64));
        upperBorder.setForeground(new Color(64,64,64));
        upperBorder.setEnabled(true);
        upperBorder.setFont(new Font("sansserif",0,12));
        // upperBorder.setOpaque(true);
        upperBorder.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(lowerBorder);
        contentPane.add(upperBorder);

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
        if(frame <= delay+death*2 && frame >= delay){
            lowerBorder.setVisible(true);
            lowerBorder.repaint();
            upperBorder.setVisible(true);
            upperBorder.repaint();
        }

        frame = frame +  spd;

        if(frame <= delay+death && frame >= delay){ //keep
            if(ori<=1){
                beat+=1;
                if(beat>width){beat/=2;}

                double x = beat;
                double y = width;
                double z = (double)x/y;
                double result = height*z;
                double result2 = height-height*z;

                lowerBorder.setBounds(0,400-(int)result,500,(int)result);
                upperBorder.setSize(500, (int)result);
            }
            else{
                beat+=1;
                if(beat>width){beat/=2;}

                double x = beat;
                double y = width;
                double z = (double)x/y;
                double result = height*z;
                double result2 = height-height*z;
                
                lowerBorder.setBounds(0,400-(int)result,500,(int)result);
                //lowerBorder.setSize(500, (int)result2);
                upperBorder.setSize(500, (int)result);
            }

            upperBorder.setForeground(new Color(255,0,0));
            upperBorder.setBackground(new Color(255,0,0));

            lowerBorder.setForeground(new Color(255,0,0));
            lowerBorder.setBackground(new Color(255,0,0));

            collision = true;

            // System.out.println(upperBorder.getBackground());
            // System.out.println("keep " + frame);
        }
        if(frame >= delay+death && frame <= delay+death*2){ //fade
            lowerBorder.setBounds(0,400-height,500,400);
            upperBorder.setBounds(0,0,500,height);
            
            double x = frame-delay-death;
            double y = death;
            double z = (double)x/y;
            double result = 255-z*255;
            upperBorder.setBackground(new Color((int)result,(int)result,(int)result)); 
            lowerBorder.setBackground(new Color((int)result,(int)result,(int)result)); 
            
            collision = false;
            // System.out.println(particle.getBackground());
            // System.out.println("x "+x+" y "+y+" z "+z+" result "+(int)result);
        }
        else if(frame >= delay+death*2){
            startX = startY = width = height = -20;
            lowerBorder.setVisible(false);
            upperBorder.setVisible(false);
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
