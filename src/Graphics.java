
import javax.management.Query;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Graphics implements ActionListener {
    private int clicks = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    JButton[][] finalAr = new JButton[6][5];
    JTextField teeth = new JTextField(5);
    JButton killMe = new JButton("");
    public Graphics() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        int x = 135;
        int y = 20;
        // buttons for each icon grid point
        for (int i = 0; i < finalAr.length; i++) {
            for (int h = 0; h < finalAr[0].length; h++) {
                JButton gj = new JButton(" ");
                gj.setBounds(x, y, 90, 90);
                finalAr[i][h] = gj;
                frame.add(gj);
                gj.setVisible(true);
                gj.setOpaque(true);
                System.out.println(i + "  " + h);
                x += 106;
            }
            y += 109;
            x = 135;
            // this is error fixing, idk what the problem is so I just hardcoded it
            killMe.setBounds(675, 810, 105, 105);
            frame.add(killMe);
            killMe.setVisible(true);
        }
        // ImageIcon icon = new ImageIcon("lib/Grid.png");
        frame.setVisible(true);
        JButton b = new JButton("submit");
        b.setBounds(5, 30, 100, 40);
        b.addActionListener(this);
        frame.add(b);
        frame.add(teeth);
        frame.setVisible(true);
        frame.add(new JLabel());
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setVisible(true);
        frame.setLocationRelativeTo(panel);
        teeth.setVisible(true);
        teeth.setBounds(4, 80, 100, 40);
        teeth.getBorder();
        frame.pack();
    }
    public void set_visible(JFrame c) {
        c.setVisible(true);
    }
    public static void main(String[] args) {
        new Graphics();

    }
    // methods needed:
    // a method that grabs a correct input and puts it on the buttons
    // a method that changes the colors
    public void buttonWord(int i, String b) {
        for (int y = 0; y < finalAr[0].length; y++) {
            if (y == 4 && i == 5) {
                killMe.setText(b.substring(y, y + 1).toUpperCase());
            }
            System.out.println(b.substring(y, y + 1));
            finalAr[i][y].setText(b.substring(y, y + 1).toUpperCase());
        }
    }
    public void buttonColor(String b, int x) {
        for (int i = 0; i < b.length(); i++) {
            if (b.substring(i, i + 1).equals("^")) {
                finalAr[x][i].setBackground(Color.YELLOW);
            } else if (b.substring(i, i + 1).equals("_")) {
                finalAr[x][i].setBackground(Color.LIGHT_GRAY);
            } else {
                finalAr[x][i].setBackground(Color.GREEN);
            }
        }
    }
    String format = "";
    public boolean playGame(Wordle b, String e) {
        Wordle wordle = b;
        System.out.println(wordle.getAnswer());
        boolean badChar = false;
        String specialChars = "`1234567890-=~!@#$%^&*()_+[]}|;:',./<>?";
        for (int i = 0; i < e.length(); i++) {
            if (specialChars.contains(e.substring(i, i + 1))) {
                System.out.println("bad char");
                badChar = true;
            }
        }
        if (e.length() > 5 || e.length() < 5) {
            System.out.println("BAD LENGTH");
            badChar = true;
        } else if (!badChar) {
            wordle.loop(e);
            format = wordle.loop(e);
            return true;
        }
        return false;
    }
    int x = 0;
    Wordle weed = new Wordle();
    public void actionPerformed(ActionEvent e) {
        String b = teeth.getText();
        if (playGame(weed, b) == true) {
            buttonWord(x, b);
            buttonColor(format, x);
            x++;
        }
        if (b.equals(weed.getAnswer())) {
            System.out.println("WINNER WINNER");
            System.out.println("You got it in " + (x - 1) + " guess(es)");
            return;
        }
        if (x == 6) {
            System.out.println("You lost!");
            System.out.println("The word was " + weed.getAnswer()); 
            return;
        }
        teeth.setText(null);
    }
}
