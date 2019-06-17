/**
 *Text genereted by Simple GUI Extension for BlueJ
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
    String input;
    private JMenuBar menuBar;
    private JPanel TimelineBackground;
    private JPanel TimelineFront;
    private JPanel panel3;
    private JButton keylistenObj; // >:| keine ahnung whyyyyyyyyyyyyyyy (bitte rausnehmen vor abgabe thx)

    //Constructor 
    public LevelView(){

        setTitle("LevelView");
        setSize(500,400);
        //menu generate method
        generateMenu();
        setJMenuBar(menuBar);

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

        panel3 = new JPanel(null);
        panel3.setBorder(BorderFactory.createEtchedBorder(1));
        panel3.setBounds(250,200,20,20);
        panel3.setBackground(new Color(214,217,223));
        panel3.setForeground(new Color(0,0,0));
        panel3.setEnabled(true);
        panel3.setFont(new Font("sansserif",0,12));
        panel3.setVisible(true);
        panel3.addKeyListener(this);

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
        contentPane.add(panel3);
        contentPane.add(keylistenObj);

        //adding panel to JFrame and seting of window position and close operation
        getContentPane().add(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    //method for generate menu
    public void generateMenu(){
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open   ");
        JMenuItem save = new JMenuItem("Save   ");
        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem preferences = new JMenuItem("Preferences   ");
        JMenuItem about = new JMenuItem("About   ");

        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }

    //base funktionen
    public Controller getController(){
        return c;
    }

    public void setController(Controller nc){
        c = nc;
    }

    public String getWindowInput(){
        return "?";
    }

    //listeners and interaction
    public void actionPerformed(ActionEvent e) {
        // if(e.getSource() == this.listenerObj){
        // goal.setText(("got start"));
        // }
    }

    public void keyPressed(KeyEvent e) {  
        // goal.setText("Pressed" + e.getKeyChar()); 
        if(e.getKeyCode() == 27){ //escape
            dispose();
            System.exit(0);
        }
    }  

    public void keyReleased(KeyEvent e) {  
        // goal.setText("Released" + e.getKeyChar());  
    }  

    public void keyTyped(KeyEvent e) {  
        // goal.setText("Typed" + e.getKeyChar());  
    }  

    public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new LevelView();
                }
            });
    }

}