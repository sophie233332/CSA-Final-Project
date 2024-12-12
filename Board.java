
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener, KeyListener {
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    
        setBackground(Color.BLACK);

    
        g.setColor(Color.WHITE); 
        g.drawString("OPERATION MANUAL ", 35, 30); 
        g.drawString("Press A---D to move left and right ", 5,50); 
        g.drawString("Press ENTER to catch the object", 5, 70); 

        g.drawString("Press W to begain the next catch ", 5, 100); 
    }

    // @Override
    // public void keyTyped(KeyEvent e) {}
    

    // @Override
    // public void keyPressed(KeyEvent e) {
        
    //     if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    //         if (i > 0) {
    //             i--; 
    //         }
    //     }
    // }

    // @Override
    // public void keyReleased(KeyEvent e) {}

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     repaint();
    // }
}
