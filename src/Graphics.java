
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
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
import java.awt.event.*;
import javax.swing.*;
public class Graphics implements ActionListener {
    private int clicks = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    public Graphics() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(50, 50, 50));
    
    JButton[][] finalAr = new JButton[6][5]; 
    int x = 135; 
    int y = 0; 
    //buttons for each icon grid point 
    for (int i = 0; i <= finalAr.length; i++){ 
        for(int h = 0; h <=finalAr[0].length; h++){
        JButton gj = new JButton("b"); 
        gj.setBounds(x, 20, 105, 105);
        frame.add(gj); 
        gj.setVisible(true); 
        finalAr[i][h] = gj; 
        x+=106; 
        }
    }


    ImageIcon icon = new ImageIcon("lib/Grid.png"); 
    
    //frame.setLayout(null);
    //frame.setLayout(new GridLayout(3, 3));        
    frame.setVisible(true);  
    JButton b = new JButton("submit");
    b.setBounds(5,30,100,40);
    JTextField t = new JTextField(5);
    
    

    frame.add(b);
    frame.add(t);
    frame.setVisible(true); 
    frame.add(new JLabel(icon)); 
    frame.setPreferredSize(new Dimension(800, 800));
    frame.setVisible(true);
    frame.setLocationRelativeTo(panel);
    t.setVisible(true);
    t.setBounds(4, 80, 100, 40);
    t.getBorder(); 
    frame.pack(); 

    

    
 
        


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


