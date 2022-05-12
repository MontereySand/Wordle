import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {

  
    private int clicks = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public GUI() {
      
        frame = new JFrame();
       
       
       JButton button = new JButton("Click me");
     
       label = new JLabel("Number of clicks: 0");
       

       panel = new JPanel();
   
       panel.add(button);
       panel.add(label);

       
       frame.setTitle("Our GUI");
       frame.pack();
       frame.setVisible(true);

       frame.getContentPane().setBackground(new Color(255,0,0));

      
           

       }

    
    public static void main(String [] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicks++;
        label.setText("Number of clicks:" + clicks);
        
    }

}
