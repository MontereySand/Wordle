import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Graphics implements ActionListener {
    private int clicks = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    public Graphics() {
        frame = new JFrame();
        JButton button = new JButton("Click me");
        label = new JLabel("Number of clicks: 0");
        panel = new JPanel();
        panel.add(button);
        panel.add(label);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(255, 0, 0));
    }
    public static void main(String[] args) {
        new Graphics();
    }
    public void actionPerformed(ActionEvent e) {
        clicks++; // increments each time you press button
        label.setText("Number of clicks:" + clicks);
    }
}


