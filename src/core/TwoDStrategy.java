package core;



import java.awt.EventQueue;
import javax.swing.JFrame;

public class TwoDStrategy extends JFrame {

    public TwoDStrategy() {

        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
                        
        setResizable(false);
        pack();
        
        setTitle("2D Strategy");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new TwoDStrategy();
                ex.setVisible(true);                
            }
        });
    }
}