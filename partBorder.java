/**
 * Partikel "border": Erstellt bewegende ränder an der Seite
 * 
 *Text genereted by Simple GUI Extension for BlueJ
 *
 * @author Nikolas Grafwallner, Nicolas Lisgaras
 * @version 07.07.19
 *
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
    public partBorder(JPanel nContentPane, Controller nC, int nX, int nY, int w, int h, int nDelay, int maxOpacity,int nDeath){
        frame = 0;
        collision = false;

        contentPane = nContentPane; //contentpane ist gür spätere aktionen Global 

        c = nC;
        ori = maxOpacity; //der Opacitity Wert wird hier umfunktioniert zur orientierung des effekts entweder oben/unten oder links/rechts

        delta = c.getView().getTickDelta(); // übernimmt das tick delta für eigenen ticker -> Synchronisation

        partCount = 1;
        input = "N/A";
        delay = nDelay;
        death = nDeath; //(default: 5000ms)
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
        lowerBorder.setOpaque(true); //komische Funktion der dinge dazu bringt sich komisch zu verhalten
        lowerBorder.setVisible(true);

        upperBorder = new JPanel();
        upperBorder.setBounds(0,0,500,h);
        upperBorder.setBackground(new Color(64,64,64));
        upperBorder.setForeground(new Color(64,64,64));
        upperBorder.setEnabled(true);
        upperBorder.setFont(new Font("sansserif",0,12));
        upperBorder.setOpaque(true);
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

    public PlayerView getPlayer(){
        return null;
    }

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
    
    //getter block
    public int getWidth(){return width;}

    public int getHeight(){return height;}

    public int getX(){return startX;}

    public int getY(){return startY;}

    public int getSpeed(){return spd;}

    public int getFrame(){return frame;}

    public void update(){
        //updatet grafik Elemente IMMER solange objekt aktiv ist
        //Die aktivität geht von 0 bis der delay wert und zusätzlich der tod wert zwei mal überschitten wird
        if(frame <= delay+death && frame >= delay){
            lowerBorder.setVisible(true);
            lowerBorder.repaint();
            upperBorder.setVisible(true);
            upperBorder.repaint();
        }

        frame = frame +  spd;
        
        //hier fehlt die up phase da nichts sich ändert
        
        if(frame <= delay+death && frame >= delay){ //keep
            if(ori<=1){
                //up / down orientierung
                beat+=1;//beat wert wird erhöht
                if(beat>width){beat/=2;}//beat reset

                double x = beat; //berechnung von prozent wert zwischen maximaler weite (aka die höhe) und beat
                double y = width;
                double z = (double)x/y;
                double result = height*z; //mathe etwas. ES FUNKTIONERT, OKAY
                double result2 = height-height*z; //alternative ausrictungs formel (unused) es ändert nur die richtung

                lowerBorder.setBounds(0,400-(int)result,500,(int)result);
                upperBorder.setSize(500, (int)result);
            }
            else{
                //left / right orientierung (ist noch nicht implementiert)
                
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

            upperBorder.setForeground(new Color(255,0,0)); //setzt die farbeeeeeeee
            upperBorder.setBackground(new Color(255,0,0));

            lowerBorder.setForeground(new Color(255,0,0));
            lowerBorder.setBackground(new Color(255,0,0));

            collision = true;

            // System.out.println(upperBorder.getBackground());
            // System.out.println("keep " + frame);
        }
        if(frame >= delay+death && frame <= delay+death*2){ //fade
            //fade animation
            
            lowerBorder.setBounds(0,400-height,500,400-1);
            upperBorder.setBounds(0,0,500,height-1);
            lowerBorder.setBounds(0,400-height,500,400);
            upperBorder.setBounds(0,0,500,height);

            double x = frame-delay-death; //start punkt in frames
            double y = death; //delta
            double z = (double)x/y; //reative postion in der end sequenz
            double result = 255-z*255; //relativer wert in % auf 0-255 übertragen
            upperBorder.setBackground(new Color((int)result,(int)result,(int)result)); 
            lowerBorder.setBackground(new Color((int)result,(int)result,(int)result)); 

            collision = false;
            // System.out.println(particle.getBackground()); //wichtige info für werte überwachung. Das kommt davon wenn man keine watches hat. Nur mal so
            // System.out.println("x "+x+" y "+y+" z "+z+" result "+(int)result);
        }
        else if(frame >= delay+death*2){
            //alles wird entfernt und unsichtbar gemacht und OOB (out of bounds) gelagert für den gc
            startX = startY = width = height = -20;
            lowerBorder.setVisible(false);
            upperBorder.setVisible(false);
        }
    }
    
    //filler für interface
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
