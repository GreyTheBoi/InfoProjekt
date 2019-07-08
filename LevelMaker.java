/**
 * Text genereted by Simple GUI Extension for BlueJ
 *
 * @author Nicolas Lisgaras
 * @version 06.07.19
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

public class LevelMaker extends JFrame implements ActionListener,View{
    
    // Der super praktische level maker vereinfacht das machen von levels UM EINIGES und ist zusammen mit MapDevHelper ein starkes tool 
    
    LevelDatabase LDB;

    private JMenuBar menuBar;
    private JLabel FrameLabel;
    private JTextField IDField;
    private JLabel IDLabel;
    private JLabel LevelMakerLabel;
    private JButton MakeButton;
    private JPanel OptionLabelsPanel;
    private JPanel TitlePanel;
    private JTextField deathField;
    private JLabel deathLabel;
    private JTextField delayField;
    private JLabel delaylabel;
    private JTextField frameField;
    private JTextField heightField;
    private JLabel heightLabel;
    private JTextField opacityField;
    private JLabel opacityLabel;
    private JLabel posXLabel;
    private JTextField posYField;
    private JLabel posYLabel;
    private JComboBox typeCombobox;
    private JLabel typeLabel;
    private JTextField widthField;
    private JLabel widthLabel;
    private JTextField posXField;

    private Ticker t;

    //Constructor 
    public LevelMaker(){

        setTitle("LevelMaker");
        setSize(330,400);
        
        LDB = new LevelDatabase();

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(330,400));
        contentPane.setBackground(new Color(64,64,64));

        FrameLabel = new JLabel();
        FrameLabel.setBounds(5,35,90,35);
        FrameLabel.setBackground(new Color(214,217,223));
        FrameLabel.setForeground(new Color(0,0,0));
        FrameLabel.setEnabled(true);
        FrameLabel.setFont(new Font("sansserif",0,12));
        FrameLabel.setText("frame:");
        FrameLabel.setVisible(true);

        IDField = new JTextField();
        IDField.setBounds(130,75,90,35);
        IDField.setBackground(new Color(255,255,255));
        IDField.setForeground(new Color(0,0,0));
        IDField.setEnabled(true);
        IDField.setFont(new Font("sansserif",0,12));
        IDField.setVisible(true);

        IDLabel = new JLabel();
        IDLabel.setBounds(5,5,90,35);
        IDLabel.setBackground(new Color(214,217,223));
        IDLabel.setForeground(new Color(0,0,0));
        IDLabel.setEnabled(true);
        IDLabel.setFont(new Font("sansserif",0,12));
        IDLabel.setText("ID:");
        IDLabel.setVisible(true);

        LevelMakerLabel = new JLabel();
        LevelMakerLabel.setBounds(80,8,135,35);
        LevelMakerLabel.setBackground(new Color(214,217,223));
        LevelMakerLabel.setForeground(new Color(0,0,0));
        LevelMakerLabel.setEnabled(true);
        LevelMakerLabel.setFont(new Font("SansSerif",1,24));
        LevelMakerLabel.setText("LevelMaker");
        LevelMakerLabel.setVisible(true);

        MakeButton = new JButton();
        MakeButton.setBounds(230,200,90,35);
        MakeButton.setBackground(new Color(255,255,255));
        MakeButton.setForeground(new Color(0,0,0));
        MakeButton.setEnabled(true);
        MakeButton.setFont(new Font("SansSerif",1,16));
        MakeButton.setText("MAKE");
        MakeButton.setVisible(true);
        MakeButton.addActionListener(this);

        OptionLabelsPanel = new JPanel(null);
        OptionLabelsPanel.setBorder(BorderFactory.createEtchedBorder(1));
        OptionLabelsPanel.setBounds(10,70,100,320);
        OptionLabelsPanel.setBackground(new Color(255,255,255));
        OptionLabelsPanel.setForeground(new Color(0,0,0));
        OptionLabelsPanel.setEnabled(true);
        OptionLabelsPanel.setFont(new Font("sansserif",0,12));
        OptionLabelsPanel.setVisible(true);

        TitlePanel = new JPanel(null);
        TitlePanel.setBorder(BorderFactory.createEtchedBorder(1));
        TitlePanel.setBounds(10,10,300,50);
        TitlePanel.setBackground(new Color(255,255,255));
        TitlePanel.setForeground(new Color(0,0,0));
        TitlePanel.setEnabled(true);
        TitlePanel.setFont(new Font("sansserif",0,12));
        TitlePanel.setVisible(true);

        deathField = new JTextField();
        deathField.setBounds(130,165,90,35);
        deathField.setBackground(new Color(255,255,255));
        deathField.setForeground(new Color(0,0,0));
        deathField.setEnabled(true);
        deathField.setFont(new Font("sansserif",0,12));
        deathField.setVisible(true);

        deathLabel = new JLabel();
        deathLabel.setBounds(5,95,90,35);
        deathLabel.setBackground(new Color(214,217,223));
        deathLabel.setForeground(new Color(0,0,0));
        deathLabel.setEnabled(true);
        deathLabel.setFont(new Font("sansserif",0,12));
        deathLabel.setText("death:");
        deathLabel.setVisible(true);

        delayField = new JTextField();
        delayField.setBounds(130,315,90,35);
        delayField.setBackground(new Color(255,255,255));
        delayField.setForeground(new Color(0,0,0));
        delayField.setEnabled(true);
        delayField.setFont(new Font("sansserif",0,12));
        delayField.setVisible(true);

        delaylabel = new JLabel();
        delaylabel.setBounds(5,245,90,35);
        delaylabel.setBackground(new Color(214,217,223));
        delaylabel.setForeground(new Color(0,0,0));
        delaylabel.setEnabled(true);
        delaylabel.setFont(new Font("sansserif",0,12));
        delaylabel.setText("delay:");
        delaylabel.setVisible(true);

        frameField = new JTextField();
        frameField.setBounds(130,105,90,35);
        frameField.setBackground(new Color(255,255,255));
        frameField.setForeground(new Color(0,0,0));
        frameField.setEnabled(true);
        frameField.setFont(new Font("sansserif",0,12));
        frameField.setVisible(true);

        heightField = new JTextField();
        heightField.setBounds(130,285,90,35);
        heightField.setBackground(new Color(255,255,255));
        heightField.setForeground(new Color(0,0,0));
        heightField.setEnabled(true);
        heightField.setFont(new Font("sansserif",0,12));
        heightField.setVisible(true);

        heightLabel = new JLabel();
        heightLabel.setBounds(5,215,90,35);
        heightLabel.setBackground(new Color(214,217,223));
        heightLabel.setForeground(new Color(0,0,0));
        heightLabel.setEnabled(true);
        heightLabel.setFont(new Font("sansserif",0,12));
        heightLabel.setText("height:");
        heightLabel.setVisible(true);

        opacityField = new JTextField();
        opacityField.setBounds(130,345,90,35);
        opacityField.setBackground(new Color(255,255,255));
        opacityField.setForeground(new Color(0,0,0));
        opacityField.setEnabled(true);
        opacityField.setFont(new Font("sansserif",0,12));
        opacityField.setVisible(true);

        opacityLabel = new JLabel();
        opacityLabel.setBounds(5,275,90,35);
        opacityLabel.setBackground(new Color(214,217,223));
        opacityLabel.setForeground(new Color(0,0,0));
        opacityLabel.setEnabled(true);
        opacityLabel.setFont(new Font("sansserif",0,12));
        opacityLabel.setText("opacity:");
        opacityLabel.setVisible(true);

        posXLabel = new JLabel();
        posXLabel.setBounds(5,125,90,35);
        posXLabel.setBackground(new Color(214,217,223));
        posXLabel.setForeground(new Color(0,0,0));
        posXLabel.setEnabled(true);
        posXLabel.setFont(new Font("sansserif",0,12));
        posXLabel.setText("X position:");
        posXLabel.setVisible(true);

        posYField = new JTextField();
        posYField.setBounds(130,225,90,35);
        posYField.setBackground(new Color(255,255,255));
        posYField.setForeground(new Color(0,0,0));
        posYField.setEnabled(true);
        posYField.setFont(new Font("sansserif",0,12));
        posYField.setVisible(true);

        posYLabel = new JLabel();
        posYLabel.setBounds(5,155,90,35);
        posYLabel.setBackground(new Color(214,217,223));
        posYLabel.setForeground(new Color(0,0,0));
        posYLabel.setEnabled(true);
        posYLabel.setFont(new Font("sansserif",0,12));
        posYLabel.setText("Y position:");
        posYLabel.setVisible(true);

        typeCombobox = new JComboBox();
        typeCombobox.setBounds(130,135,90,35);
        typeCombobox.setBackground(new Color(214,217,223));
        typeCombobox.setForeground(new Color(0,0,0));
        typeCombobox.setEnabled(true);
        typeCombobox.setFont(new Font("sansserif",0,12));
        typeCombobox.setVisible(true);
        typeCombobox.addItem("err");
        typeCombobox.addItem("ait");
        typeCombobox.addItem("pop");
        typeCombobox.addItem("bullet");
        typeCombobox.addItem("border");

        typeLabel = new JLabel();
        typeLabel.setBounds(5,65,90,35);
        typeLabel.setBackground(new Color(214,217,223));
        typeLabel.setForeground(new Color(0,0,0));
        typeLabel.setEnabled(true);
        typeLabel.setFont(new Font("sansserif",0,12));
        typeLabel.setText("type:");
        typeLabel.setVisible(true);

        widthField = new JTextField();
        widthField.setBounds(130,255,90,35);
        widthField.setBackground(new Color(255,255,255));
        widthField.setForeground(new Color(0,0,0));
        widthField.setEnabled(true);
        widthField.setFont(new Font("sansserif",0,12));
        widthField.setVisible(true);

        widthLabel = new JLabel();
        widthLabel.setBounds(5,185,90,35);
        widthLabel.setBackground(new Color(214,217,223));
        widthLabel.setForeground(new Color(0,0,0));
        widthLabel.setEnabled(true);
        widthLabel.setFont(new Font("sansserif",0,12));
        widthLabel.setText("width:");
        widthLabel.setVisible(true);

        posXField = new JTextField();
        posXField.setBounds(130,195,90,35);
        posXField.setBackground(new Color(255,255,255));
        posXField.setForeground(new Color(0,0,0));
        posXField.setEnabled(true);
        posXField.setFont(new Font("sansserif",0,12));
        posXField.setVisible(true);

        //adding components to contentPane panel
        OptionLabelsPanel.add(FrameLabel);
        contentPane.add(IDField);
        OptionLabelsPanel.add(IDLabel);
        TitlePanel.add(LevelMakerLabel);
        contentPane.add(MakeButton);
        contentPane.add(OptionLabelsPanel);
        contentPane.add(TitlePanel);
        contentPane.add(deathField);
        OptionLabelsPanel.add(deathLabel);
        contentPane.add(delayField);
        OptionLabelsPanel.add(delaylabel);
        contentPane.add(frameField);
        contentPane.add(heightField);
        OptionLabelsPanel.add(heightLabel);
        contentPane.add(opacityField);
        OptionLabelsPanel.add(opacityLabel);
        OptionLabelsPanel.add(posXLabel);
        contentPane.add(posYField);
        OptionLabelsPanel.add(posYLabel);
        contentPane.add(typeCombobox);
        OptionLabelsPanel.add(typeLabel);
        contentPane.add(widthField);
        OptionLabelsPanel.add(widthLabel);
        contentPane.add(posXField);

        //adding panel to JFrame and seting of window position and close operation
        getContentPane().add(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        
        t = new Ticker(this,20);
    }

    public String getWindowInput(){
        return "N/A";
    }

    public void update(){
        //manchmal ändern sich die bedeutungen der DB einträge und das wird angepasst
        if(typeCombobox.getSelectedItem().toString() == "pop"){
            widthLabel.setText("speed:");
        }
        else if(typeCombobox.getSelectedItem().toString() == "bullet"){
            widthLabel.setText("speed:");
            opacityLabel.setText("direction:");
        }
        else if(typeCombobox.getSelectedItem().toString() == "border"){
            widthLabel.setText("beat:");
            opacityLabel.setText("orientation:");
            posXLabel.setText("obsolete:");
            posYLabel.setText("obsolete:");
        }
        else{
            widthLabel.setText("width:");
            opacityLabel.setText("opacity:");
            posXLabel.setText("X position:");
            posYLabel.setText("Y position:");
        }
    }
    
    public PlayerView getPlayer(){
        return null;
    }

    public Controller getController(){
        return null;
    }

    public void setController(Controller nc){

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

    public void actionPerformed(ActionEvent e) {
        //auswertung der inputs und DIEREKTE einführung in die datenbank
        if(e.getSource() == this.MakeButton){
            int ID = Integer.parseInt(IDField.getText());
            int frame = Integer.parseInt(frameField.getText());
            String type = typeCombobox.getSelectedItem().toString();
            int death = Integer.parseInt(deathField.getText());
            int posX = Integer.parseInt(posXField.getText());
            int posY = Integer.parseInt(posYField.getText());
            int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());
            int delay = Integer.parseInt(delayField.getText());
            int opacity = Integer.parseInt(opacityField.getText());

            LDB.insert(ID, frame, type, death, posX, posY, width, height, delay, opacity);
            LDB.selectAll(); //hier wird die datenbank angezeigt
        }
    }
}