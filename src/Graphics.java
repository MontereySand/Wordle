
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Graphics implements ActionListener {
    private int clicks = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    public Graphics() {
        frame = new JFrame();
        // frame.getContentPane().setBackground(new Color(50, 50, 50));
        // ImageIcon icon = new ImageIcon("lib/Grid.png"); 
        // frame.add(new JLabel(icon)); 
        // frame.setPreferredSize(new Dimension(800, 800));
        // frame.setVisible(true);
        // frame.pack(); 
        // frame.setLocationRelativeTo(panel);
JButton btn = new JButton(); 
JTextField text = new JTextField();  
btn.add(text); 
btn.setVisible(true); 
frame.setLayout(new GridLayout(5, 6));    
frame.setSize(800, 800);    
frame.setVisible(true);  
frame.add(btn); 


//plan: the btn will have an enter button, 
//and that will send it throguh wordle.java
//after that, the text will be displayed on a grid
//and then the color can change 

}
   
    public void set_visible(JFrame c){
        c.setVisible(true); 
    }

    public static void main(String[] args) {
        new Graphics();
        
    }
    public void actionPerformed(ActionEvent e) {
        clicks++; // increments each time you press button
        label.setText("Number of clicks:" + clicks);
    }
}


