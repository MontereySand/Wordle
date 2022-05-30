import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import java.util.ArrayList;

public class Wordle {
    private final Timer timer;
    private final String gameanswer;
    private String specialChars;
    private final TimerTask task;
    private int seconds;

    public Wordle() {
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
