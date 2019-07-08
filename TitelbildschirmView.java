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

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 *Text genereted by Simple GUI Extension for BlueJ
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */

public class TitelbildschirmView extends JFrame implements View, KeyListener, ActionListener {
    Controller c;

    String input;
    boolean keyPressed;

    private JButton AnleitungButton;
    private JRadioButton Einstellung1RadioButton;
    private JRadioButton Einstellung2RadioButton;
    private JRadioButton Einstellung3RadioButton;
    private JLabel EinstellungLabel;
    private JButton EndeButton;
    private JLabel LabelVon;
    private JButton LadenButton;
    private JTextArea NameTexarea;
    private JButton StartButton;
    private JLabel TitelLabel;
    private JPanel TitelPanel;
    private JPanel VonPanel;
    private JPanel panel2;

    private AudioPlayer audio;

    //Constructor 
    public TitelbildschirmView(){

        setTitle("Titelbildschirm");
        setSize(500,400);

        audio = new AudioPlayer("MenuScreen.wav");
        audio.start();

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(0,0,0));

        AnleitungButton = new JButton();
        AnleitungButton.setBounds(425,335,50,50);
        AnleitungButton.setBackground(new Color(255,255,255));
        AnleitungButton.setForeground(new Color(0,0,0));
        AnleitungButton.setEnabled(true);
        AnleitungButton.setFont(new Font("SansSerif",1,24));
        AnleitungButton.setText("?");
        AnleitungButton.setVisible(true);
        AnleitungButton.addActionListener(this);

        Einstellung1RadioButton = new JRadioButton();
        Einstellung1RadioButton.setBounds(10,55,90,35);
        Einstellung1RadioButton.setBackground(new Color(255,255,255));
        Einstellung1RadioButton.setForeground(new Color(0,0,0));
        Einstellung1RadioButton.setEnabled(true);
        Einstellung1RadioButton.setFont(new Font("sansserif",0,12));
        Einstellung1RadioButton.setText("Effekte");
        Einstellung1RadioButton.setVisible(true);

        Einstellung2RadioButton = new JRadioButton();
        Einstellung2RadioButton.setBounds(10,90,90,35);
        Einstellung2RadioButton.setBackground(new Color(255,255,255));
        Einstellung2RadioButton.setForeground(new Color(0,0,0));
        Einstellung2RadioButton.setEnabled(true);
        Einstellung2RadioButton.setFont(new Font("sansserif",0,12));
        Einstellung2RadioButton.setText("Skill");
        Einstellung2RadioButton.setVisible(true);

        Einstellung3RadioButton = new JRadioButton();
        Einstellung3RadioButton.setBounds(10,125,90,35);
        Einstellung3RadioButton.setBackground(new Color(255,255,255));
        Einstellung3RadioButton.setForeground(new Color(0,0,0));
        Einstellung3RadioButton.setEnabled(true);
        Einstellung3RadioButton.setFont(new Font("sansserif",0,12));
        Einstellung3RadioButton.setText("Dev tools");
        Einstellung3RadioButton.setVisible(true);

        EinstellungLabel = new JLabel();
        EinstellungLabel.setBounds(10,15,110,38);
        EinstellungLabel.setBackground(new Color(214,217,223));
        EinstellungLabel.setForeground(new Color(0,0,0));
        EinstellungLabel.setEnabled(true);
        EinstellungLabel.setFont(new Font("SansSerif",0,18));
        EinstellungLabel.setText("Einstellungen");
        EinstellungLabel.setVisible(true);

        EndeButton = new JButton();
        EndeButton.setBounds(185,270,120,50);
        EndeButton.setBackground(new Color(255,255,255));
        EndeButton.setForeground(new Color(0,0,0));
        EndeButton.setEnabled(true);
        EndeButton.setFont(new Font("SansSerif",1,24));
        EndeButton.setText("Ende");
        EndeButton.setVisible(true);
        EndeButton.addActionListener(this);

        LabelVon = new JLabel();
        LabelVon.setBounds(38,13,45,25);
        LabelVon.setBackground(new Color(214,217,223));
        LabelVon.setForeground(new Color(0,0,0));
        LabelVon.setEnabled(true);
        LabelVon.setFont(new Font("SansSerif",0,18));
        LabelVon.setText("von: ");
        LabelVon.setVisible(true);

        LadenButton = new JButton();
        LadenButton.setBounds(185,210,120,50);
        LadenButton.setBackground(new Color(255,255,255));
        LadenButton.setForeground(new Color(0,0,0));
        LadenButton.setEnabled(true);
        LadenButton.setFont(new Font("SansSerif",1,24));
        LadenButton.setText("Laden");
        LadenButton.setVisible(true);
        LadenButton.addActionListener(this);

        NameTexarea = new JTextArea();
        NameTexarea.setBounds(15,60,100,80);
        NameTexarea.setBackground(new Color(255,255,255));
        NameTexarea.setForeground(new Color(0,0,0));
        NameTexarea.setEnabled(false);
        NameTexarea.setFont(new Font("SansSerif",0,18));
        NameTexarea.setText("Nicolas L.\nNiko G.");
        NameTexarea.setBorder(BorderFactory.createBevelBorder(1));
        NameTexarea.setVisible(true);

        StartButton = new JButton();
        StartButton.setBounds(185,149,120,50);
        StartButton.setBackground(new Color(255,255,255));
        StartButton.setForeground(new Color(0,0,0));
        StartButton.setEnabled(true);
        StartButton.setFont(new Font("SansSerif",1,24));
        StartButton.setText("Start");
        StartButton.setVisible(true);
        StartButton.addActionListener(this);

        TitelLabel = new JLabel();
        TitelLabel.setBounds(130,25,250,45);
        TitelLabel.setBackground(new Color(214,217,223));
        TitelLabel.setForeground(new Color(0,0,0));
        TitelLabel.setEnabled(true);
        TitelLabel.setFont(new Font("SansSerif",1,28));
        TitelLabel.setText("B I T   T u n e s");
        TitelLabel.setVisible(true);

        TitelPanel = new JPanel(null);
        TitelPanel.setBorder(BorderFactory.createEtchedBorder(1));
        TitelPanel.setBounds(25,25,450,100);
        TitelPanel.setBackground(new Color(255,255,255));
        TitelPanel.setForeground(new Color(255,255,255));
        TitelPanel.setEnabled(true);
        TitelPanel.setFont(new Font("sansserif",0,12));
        TitelPanel.setVisible(true);

        VonPanel = new JPanel(null);
        VonPanel.setBorder(BorderFactory.createEtchedBorder(1));
        VonPanel.setBounds(25,140,125,175);
        VonPanel.setBackground(new Color(255,255,255));
        VonPanel.setForeground(new Color(0,0,0));
        VonPanel.setEnabled(true);
        VonPanel.setFont(new Font("sansserif",0,12));
        VonPanel.setVisible(true);

        panel2 = new JPanel(null);
        panel2.setBorder(BorderFactory.createEtchedBorder(1));
        panel2.setBounds(350,140,125,175);
        panel2.setBackground(new Color(255,255,255));
        panel2.setForeground(new Color(255,255,255));
        panel2.setEnabled(true);
        panel2.setFont(new Font("sansserif",0,12));
        panel2.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(AnleitungButton);
        panel2.add(Einstellung1RadioButton);
        panel2.add(Einstellung2RadioButton);
        panel2.add(Einstellung3RadioButton);
        panel2.add(EinstellungLabel);
        contentPane.add(EndeButton);
        VonPanel.add(LabelVon);
        contentPane.add(LadenButton);
        VonPanel.add(NameTexarea);
        contentPane.add(StartButton);
        TitelPanel.add(TitelLabel);
        contentPane.add(TitelPanel);
        contentPane.add(VonPanel);
        contentPane.add(panel2);

        AnleitungButton.addKeyListener(this); //keine
        Einstellung1RadioButton.addKeyListener(this); //ahnung 
        Einstellung2RadioButton.addKeyListener(this); //wie
        Einstellung3RadioButton.addKeyListener(this); //man
        EinstellungLabel.addKeyListener(this); //listener
        EndeButton.addKeyListener(this); //sonst
        LabelVon.addKeyListener(this); //überall
        LadenButton.addKeyListener(this); //hat
        NameTexarea.addKeyListener(this); //¯\_(ツ)_/¯
        StartButton.addKeyListener(this);
        TitelLabel.addKeyListener(this);
        TitelPanel.addKeyListener(this);
        VonPanel.addKeyListener(this);
        panel2.addKeyListener(this);
        contentPane.addKeyListener(this);

        //adding panel to JFrame and seting of window position and close operation
        getContentPane().add(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane.setFocusable(true);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public PlayerView getPlayer(){
        return null;
    }

    //change screen sollte im interface (View) stehen @view!!
    /**
     * Ändert die view und gibt es an den controller weiter (Passiert hier da die änderung hier verarbeitet)
     */
    public void changeScreen(View newView, Controller newController)
    {
        newController.setView(newView);
        newView.setController(newController);
        dispose();
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
        return input;
    }

    public int getTick(){
        return -1;
    }

    public boolean getKeyState(){
        return keyPressed; 
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.StartButton){
            //EinstellungLabel.setText(("got start"));

            AudioPlayer bp = new AudioPlayer("button.wav");
            bp.start();

            StartButton.setText("Loading");
            System.out.println("Loading");

            audio.stop();

            for(long i = -32000;i<32000;i++){}

            System.out.println("ended");

            Controller nc;
            nc = new LevelController();

            View nv;
            nv = new LevelView();

            changeScreen(nv, nc);
        }
        else if(e.getSource() == this.EndeButton){
            //got ende 
            AudioPlayer bp = new AudioPlayer("button.wav");
            bp.start();
            for(long i = -3200000;i<3200000;i++){}
            dispose();
            System.exit(0);
        }
        else if(e.getSource() == this.LadenButton){
            //got ende 
            AudioPlayer bp = new AudioPlayer("button.wav");
            bp.start();
        }
        else if(e.getSource() == this.AnleitungButton){
            AudioPlayer bp = new AudioPlayer("button.wav");
            bp.start();

            if (Desktop.isDesktopSupported()) {
                try {
                    File theUMFile = new File("Anleitung.pdf");
                    Desktop.getDesktop().open(theUMFile);
                }
                catch (FileNotFoundException fnf){
                    System.out.println("error: file not found"+fnf);
                }
                catch (IllegalArgumentException fnf) {
                    System.out.println("error: file not found"+fnf);
                }
                catch (IOException ex) {
                    System.out.println("error: cannot open file"+ex);
                }
            } 
        }
    }

    //escape schließt das Programm (nicht nur das Fenster)
    public void keyPressed(KeyEvent e) {  
        //EinstellungLabel.setText("Pressed" + e.getKeyChar()); 
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){ //escape
            dispose();
            System.exit(0); //diese Line schließt das Programm (nicht nur das Fenster)
        }
    }  

    public void keyReleased(KeyEvent e) {  
        //EinstellungLabel.setText("Released" + e.getKeyChar());  
    }  

    public void keyTyped(KeyEvent e) {  
        //EinstellungLabel.setText("Typed" + e.getKeyChar());  
    }  

    public void update(){
        //leer
    }

    public int getTickDelta(){
        return -1;
    }

    public JPanel getContentPaneObj(){
        return null;
    }
}