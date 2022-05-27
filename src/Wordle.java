import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.ArrayList;
public class Wordle implements ActionListener {
    private final Timer timer;
    private final String gameanswer; 
    private final String specialChars;
    private final TimerTask task;
    private int seconds;
    private JFrame frame;
    private JLabel[][] grid;
    private JTextField inputField;
    private JButton button;
    private String currentGuess;
    public Wordle() {
        this.currentGuess = "";
        gameanswer = wordExtractor();
        specialChars = "`1234567890-=~!@#$%^&*()_+[]}|;:',./<>?";
        seconds = 0;
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                seconds++;
            }
        };
    }
    public String getAnswer() {
        return gameanswer;
    }
    public String wordExtractor() {
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
        String word = words.get((int) (Math.random() * words.size()));
        return word;
    }
    public String format(String s) {
        String formatted = "";
        String answer = gameanswer.toLowerCase();
        String checker = "";
        String checker2 = ""; 
        boolean isTwo = false; 
        for(int x = 0; x < answer.length(); x++){
            for(int y = 0; y < answer.length(); y++){
                if(answer.substring(x, x+1).equals(answer.substring(y, y+1)) && y!=x){
                    if(isTwo && !answer.substring(y, y+1).equals(checker)){
                        checker2 = answer.substring(y, y+1); 
                    }
                    else{
                    checker = answer.substring(y, y+1); 
                    isTwo = true; }
                }
            }

        }
      //  System.out.println(checker); 
        //System.out.println(checker2); 
        for(int x = 0; x < answer.length(); x++){
            for(int y = 0; y < answer.length(); y++){
                if(s.substring(x, x+1).equals(s.substring(y, y+1)) && y !=x){
                    if(checker.equals(s.substring(x, x+1)) || checker2.equals(s.substring(x, x+1))){
                        //System.out.println("i do something"); 
                        continue; 
                    }
                else{
                    s = s.substring(0, y) + "_" + s.substring(y+1);
                }
                   
                }
            }

        }
        System.out.println(s); 
        for (int i = 0; i < 5; i++) {
            if (s.substring(i, i + 1).equals(answer.substring(i, i + 1))) {
                formatted += answer.substring(i, i + 1);
            } else if (answer.contains(s.substring(i, i + 1))) {
                formatted += "^";
            } else if (!answer.contains(s.substring(i, i + 1))) {
                formatted += "_";
            }
        }
        return formatted;
    }
    public String loop(String e) {
        String s = format(e);
        System.out.println(s);
        return s;
    }
    public void timerStart() {
        timer.scheduleAtFixedRate(task, 1000, 1000);

    }
    public static void main(String[] args) {
        Wordle wordle = new Wordle();
        wordle.loop("e");
    }
}

