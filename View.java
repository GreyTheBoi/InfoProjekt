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
 * 
 * @author Nicolas Lisgaras 
 * @version 20.06.19
 * 
 */

interface View
{
    String getWindowInput();
    void update();
    
    //base funktionen
    Controller getController();
    void setController(Controller nc);
    int getTick();
    int getTickDelta();
    
    public JPanel getContentPaneObj();
}
