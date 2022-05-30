import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Graphics implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    JButton[][] finalAr = new JButton[6][5];
    JTextField teeth = new JTextField(5);
    JButton killMe = new JButton("");
    List<JButton> alpha = new ArrayList();

    public Graphics() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(70, 70, 70));

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
        // alphabet button creator
        String alphab = "qwertyuiopasdfghjklzxcvbnm";
        int l = 700;
        int d = 100;
        for (int i = 0; i < 10; i++) {
            JButton gj = new JButton(alphab.substring(i, i + 1));
            gj.setBounds(l, d, 30, 30);
            frame.add(gj);
            alpha.add(gj);
            gj.setVisible(true);
            gj.setOpaque(true);
            d += 50;
        }
        d = 134;
        l = 750;
        for (int i = 10; i < 19; i++) {

            JButton gj = new JButton(alphab.substring(i, i + 1));
            gj.setBounds(l, d, 30, 30);
            frame.add(gj);
            alpha.add(gj);
            gj.setVisible(true);
            gj.setOpaque(true);
            d += 50;
            System.out.println(gj);
        }
        d = 180;
        System.out.println(alphab.length());
        // for(int i = alphab.length()-1; i>=19; i--){
        for (int i = 19; i < alphab.length(); i++) {
            l = 800;

            JButton gj = new JButton(alphab.substring(i, i + 1));
            gj.setBounds(l, d, 30, 30);
            frame.add(gj);
            alpha.add(gj);
            gj.setVisible(true);
            gj.setOpaque(true);
            d += 50;
            System.out.println(gj);

        }
        frame.add(new JButton());
        JButton neww = new JButton();
        alpha.add(0, neww);

        frame.setVisible(true);
        JButton b = new JButton("submit");
        b.setBounds(5, 30, 100, 40);
        b.addActionListener(this);
        b.setBackground(Color.DARK_GRAY);
        frame.add(b);
        frame.add(teeth);
        frame.setVisible(true);
        frame.add(new JLabel());
        frame.setPreferredSize(new Dimension(900, 800));
        frame.setBounds(500, 500, 900, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(panel);
        teeth.setVisible(true);
        teeth.setBounds(4, 80, 100, 40);
        teeth.getBorder();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public void set_visible(JFrame c) {
        c.setVisible(true);
    }

    public static void main(String[] args) {
        new Graphics();
        try {
            HashMap<String, BufferedImage> GreenLetters = ImageLoader.LoadImage("Letters Green.png");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
                finalAr[x][i].setBackground(Color.DARK_GRAY);
            } else {
                finalAr[x][i].setBackground(Color.GREEN);
            }
        }
    }

    // needs work
    String alphab = "qwertyuiopasdfghjklzxcvbnm";

    // public void alphaColor(String b, String format) {
    //     int holder = 0;
    //     for (int i = 0; i < format.length(); i++) {
    //         if (format.substring(i, i + 1).equals("^")) {
    //             holder = alphab.indexOf(b.substring(i, i + 1));
    //             alpha.get(holder + 1).setBackground(Color.YELLOW);
    //             alphab = alphab.substring(0) + "_" + alphab.substring(holder, alphab.length());

    //         } else if (format.substring(i, i + 1).equals("_")) {
    //             holder = alphab.indexOf(b.substring(i, i + 1));
    //             alpha.get(holder + 1).setBackground(Color.GRAY);
    //             alphab = alphab.substring(0) + "_" + alphab.substring(holder, alphab.length());

    //         } else {
    //             holder = alphab.indexOf(b.substring(i, i + 1));
    //             alpha.get(holder + 1).setBackground(Color.GREEN);
    //             alphab = alphab.substring(0) + "_" + alphab.substring(holder, alphab.length());

    //         }
    //     }

    // }

    public void popOut(String s){
       
            final JFrame parent = new JFrame();
            JLabel button = new JLabel(); 
            parent.add(button); 
            button.setText(s);
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setVisible(true); 
            parent.pack(); 
            parent.setBounds(300, 200, 150, 150);
            parent.setVisible(true);
        }
    

    String format = "";

    public boolean playGame(Wordle b, String e) {
        Wordle wordle = b;
        boolean badChar = false;
        String specialChars = "`1234567890-=~!@#$%^&*()_+[]}|;:',./<>?";

        for (int i = 0; i < e.length(); i++) {
            if (specialChars.contains(e.substring(i, i + 1))) {
                //System.out.println("bad char");
                badChar = true;
                popOut("Bad character(s)");
            }
        }
        if (e.length() > 5 || e.length() < 5) {
            //System.out.println("BAD LENGTH");
            badChar = true;
            popOut("Bad length"); 
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
        System.out.println(weed.getAnswer());
        String b = teeth.getText();
        if (playGame(weed, b) == true) {
            buttonWord(x, b);
            buttonColor(format, x);
            //alphaColor(b, format);
            x++;
        }
        if (b.equals(weed.getAnswer())) {
            // System.out.println("WINNER WINNER");
            // System.out.println("You got it in " + (x - 1) + " guess(es)");
            popOut("WINNER WINNER. You got it in " + (x) + " guess(es)"); 
            return;
        }
        if (x == 6) {
            // System.out.println("You lost!");
            // System.out.println("The word was " + weed.getAnswer());
            popOut("You lost. The word was " + weed.getAnswer()); 
            return;
        }
        teeth.setText(null);
    }
}
