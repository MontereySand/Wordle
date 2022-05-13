import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.*;
    
   public class WordleGraphics extends JFrame implements ActionListener {

      private static JPanel panel;
      private static JFrame frame;

      private static JLabel title;
      private static JLabel stats;
      private static JTextField user;
      private static JLabel [] labels;

      public static String [] words;
      public static int numTries;
      public static char[] input;
      public static long startTime;
      public static char[] answer;
      public static boolean done;
      public static String answerChoosen;
      private String gameanswer;

      public static Scanner s = new Scanner (System.in);

      public static void main(String [] args) {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(220,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);
        title = new JLabel("Wordle: ");
        title.setBounds(10,20,100,25);
        panel.add(title);

        panel.setLayout(null);
        stats = new JLabel("Type a five letter word:");
        stats.setBounds(10,50,200,25);
        panel.add(stats);

        user = new JTextField();
        user.addActionListener(new GUI());
        user.setBounds(40,80,80,25);
        panel.add(user);

        JButton button = new JButton("Enter");
        button.setBounds(100,20,80,25);
        button.addActionListener(new GUI());
        panel.add(button);

        labels = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            labels[i] = new JLabel("----");
            labels[i].setBounds(44,80,80,25);
            panel.add(labels[i]);
        }
        frame.setVisible(true);
        StartWordle();
      }

      public static void StartWordle() {

        ArrayList<String> words = new ArrayList<String>();
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("lib/dict.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str;
        while (sc.hasNext()) {
            str = sc.next();
            words.add(str);
        }
    }

    public static void EndWordle() {
        System.out.println("The answer was:");
        System.out.println("You found the answer in: " + numTries + "tries");

        user.setEnabled(false);
        user.setVisible(false);
    }       

    public void actionPerformed(ActionEvent e) {
        
    }

    public static void ButtonPressed() {
        user.setBounds(40,80 + (numTries+1)*25), 80, 25);

        String userinput = user.getText();
        int [] colorLetters = PlayWordle(userinput);

        for (int i: colorLetters) {
            if (i!=2)
            done= false;
        }
        if (done || numTries > 5) {
            EndWordle();
            
        }
        String [] numsToColors = new String [5];
        for (int i = 0; i < 5; i++) {
            if (colorLetters[i] == 0)
            numsToColors[i] = "black";
            if (colorLetters[i] == 1)
            numsToColors[i] = "orange";
            if (colorLetters[i] == 2)
            numsToColors[i] = "green";
        }

        public static int[] PlayWordle (String guess) {
            done = false;
            numTries++;

            String a = guess.toLowerCase();

            for (int i = 0; i < 5; i++) {
                input[i] = a.charAt(i);
            }
        


        }
    }

}


        

     
    
   