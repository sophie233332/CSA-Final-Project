import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Title extends JPanel implements ActionListener, KeyListener {
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        setBackground(Color.BLACK);

        g.setColor(Color.WHITE); 
        g.drawString("HELLO " , 55, 140); 
        g.drawString("press x to start the game " , 55, 150); 

    
}
}
