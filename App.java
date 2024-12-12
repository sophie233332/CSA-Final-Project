
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
public class App {

    public static void main(String[] args) {



        // prize frame 
        int W4 = 370;
        int H4 = 200;
        JFrame frame4 = new JFrame("TheEnd");
        frame4.setSize(W4, H4);
        frame4.setLocation(540, 290); 
        frame4.setResizable(false);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        END end = new END();
        frame4.add(end);


        // board frame

        int W3 = 200;
        int H3 = 200;
        JFrame frame3 = new JFrame("board");
        frame3.setSize(W3, H3);
        frame3.setLocation(200, 100);
        frame3.setResizable(false);
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Board board = new Board();
        frame3.add(board);


        // CLAW MACHINE
        int W1 = 370;
        int H1 = 400;
        JFrame frame = new JFrame("Claw Machine");
        frame.setSize(W1, H1);
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ClawMachine clawMachine = new ClawMachine(); 
        frame.add(clawMachine);

        

        //Title
        int W2 = 260;
        int H2 = 260;
        JFrame frame2 = new JFrame("Title Page");
        frame2.setSize(W2, H2);
        frame2.setLocation(540, 90); 
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Title titlePanel = new Title();
        
        frame2.add(titlePanel);

        // Display title frame first
        frame2.setVisible(true);

        //title closed, two more pop out
        frame2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(true);
                frame3.setVisible(true);
        
            }
        });
            // the end?
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame4.setVisible(true);
        
            }
        });


    }

}