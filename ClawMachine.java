
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ClawMachine extends JPanel implements ActionListener, KeyListener {
    int W1 = 360;
    int H1 = 360;

    Image machineImg;
    Image clawImg;

    int clawX = W1 / 6;
    int clawY = H1 / 5; 
    int CW = 60;
    int CH = 60;

    class Claw {
        int x = clawX;
        int y = clawY;
        int width = CW;
        int height = CH;
        Image img;

        Claw(Image img) {
            this.img = img;
        }
    }

    // Game logic
    Claw claw;
    int press = 0;
    int down = 0;
    int coin = 4;
    ArrayList<String> objects = new ArrayList<>(); 

    Timer gameLoop;

    ClawMachine() {
        setPreferredSize(new Dimension(W1, H1));
        setBackground(Color.BLACK); 

        machineImg = new ImageIcon(getClass().getResource("./machine.png")).getImage(); 
        clawImg = new ImageIcon(getClass().getResource("./claw.png")).getImage();
        claw = new Claw(clawImg);

        gameLoop = new Timer(1000 / 60, this); // 60 FPS game loop
        gameLoop.start();
        objects.add("what you have just acquired    was nothing but 1cm^3 of fresh air");
        objects.add("Something tiny and mystery  Unlikely to be visible to naked eye");
        objects.add("EXTRA LIFE?  or just another 1cm^3 of fresh air ");
        objects.add("dark matter*d8hudj80");
        objects.add("hmmmm hmmmmmm");

        setFocusable(true); // Allows component to receive focus for key events
        addKeyListener(this); // Add KeyListener to the panel
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(machineImg, 0, 0, W1, H1, null);
        g.drawImage(claw.img, claw.x, claw.y, claw.width, claw.height, null);
    }

    public void move() {
        claw.x += press;
        // Clamp claw.x to stay within panel boundaries
        claw.x = Math.max(35, Math.min(claw.x, W1 - CW - 44));
        claw.y -= down;
        // Clamp claw.x to stay within panel boundaries
        claw.y = Math.max(clawY, Math.min(claw.y, H1-210));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
    private boolean disableAD = false;
    private boolean disableENTER = false;

    @Override
    public void keyPressed(KeyEvent e) {
        if (disableAD) {
            // Reset the action for A and D if they are pressed while disableAD is true
            if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
                // Do nothing when A or D is pressed after other key
                return;
            }
        }
        if (disableENTER){
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                // Do nothing when enter is pressed after other key
                return;
            }


        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            press = -6; // Move left
        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            press = 6; // Move right
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            disableAD = true;
            down = -2;
    
            Random random = new Random();
            int randomIndex = random.nextInt(objects.size());
            String selectedObject = objects.get(randomIndex);

            System.out.println(selectedObject);

            System.out.println("you now have " + coin-- + " times  left to play"); 
            
            if (coin == -1) {
                System.out.println("No coins left. Quitting game...");
                SwingUtilities.getWindowAncestor(this).dispose();
            }
            
            disableENTER = true;  
        }
        else if (e.getKeyCode() == KeyEvent.VK_W){
            disableAD = false;
            down = 2;  
            disableENTER = false;
        }

        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
            press = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // not used
    }
    
}