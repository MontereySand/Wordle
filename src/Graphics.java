import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Graphics implements ActionListener {
    private int clicks = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    public Graphics() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        ImageIcon icon = new ImageIcon("lib/Grid.png"); 
        frame.add(new JLabel(icon)); 
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setVisible(true);
        frame.pack(); 
        frame.setLocationRelativeTo(panel);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
            JFrame myFrame = new JFrame();
            JPanel myPanel = new JPanel();
        
            for (int i = 0; i < alphabet.length(); i++) {
                myPanel.add(new JButton(alphabet.substring(i, i + 1)));
            }
        
            myFrame.add(myPanel);
            myFrame.pack();
            myFrame.setVisible(true);
    
    }

    public static void main(String[] args) {
        new Graphics();
        
    }
    public void actionPerformed(ActionEvent e) {
        clicks++; // increments each time you press button
        label.setText("Number of clicks:" + clicks);
    }
}


