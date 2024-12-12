import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class Prize extends JPanel implements ActionListener, KeyListener {
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Set background color to white
        setBackground(Color.BLACK);

        g.setColor(Color.WHITE); // Set the text color
        g.setFont(new Font("Serif", Font.BOLD, 36));
        g.drawString("GAME", 95, 70);
        g.drawString("OVER?", 125, 100);
        
    }
}
