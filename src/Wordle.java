import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
public class Wordle {
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            seconds++;
        }
    };
    private String gameanswer;
    private String specialChars;
    private int seconds;
    public void timerStart() {
        timer.scheduleAtFixedRate(task, 1000, 1000);

    }
    public Wordle() {
        gameanswer = wordExtractor();
        specialChars = "0123456789/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        seconds = 0;
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
    public String getAnswer() {
        return gameanswer;

    }
    public String format(String s) {
        String formatted = "";
        String answer = gameanswer;
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
    public void play() {
        Wordle wordle = new Wordle();
        seconds = 0;
        System.out.println(wordle.getAnswer() + " - this is the answer for debugging :)");
        String currentGuess;
        System.out.println("Enter Guess #1:");
        Scanner input = new Scanner(System.in);
        currentGuess = input.nextLine().toLowerCase();
        while (currentGuess.length() != 5) {
            System.out.println("Enter A 5 Letter Word, Try again");
            currentGuess = input.nextLine();
        }
        for (int i = 0; i < currentGuess.length(); i++) {
            if (specialChars.contains(currentGuess.substring(i, i + 1))) {
                System.out.println("Enter a valid word, try again");
                System.out.println("Enter Guess #1: ");
                currentGuess = input.nextLine();
            }
        }
        if (wordle.format(currentGuess).equals(wordle.getAnswer())) {
            System.out.println("First try? Seems a little suspicious :)");
            System.out.println("You won in " + seconds + " seconds");
            return;
        }
        System.out.println(wordle.format(currentGuess));
        int i = 1;
        while (currentGuess != wordle.getAnswer()) {
            System.out.println("Enter Guess #" + (i + 1) + ":");
            currentGuess = input.nextLine();
            if (currentGuess.length() != 5) {
                System.out.println("Enter A 5 Letter Word, Try again");
                continue;
            }
            System.out.println(wordle.format(currentGuess));
            if (i > 4) {
                System.out.println("Better luck next time, the answer was");
                System.out.println(wordle.getAnswer() + ":)");
                System.out.println("The round took " + seconds + " seconds");
                return;
            }
            i++;
            if (wordle.format(currentGuess).equals(wordle.getAnswer())) {
                System.out.println("Good Job! You won the Wordle");
                System.out.println("You got the word in " + seconds + " seconds");
                break;
            }
        }
    }
    public void loop() {
        System.out.println("Wordle");
        System.out.println("Start/Quit");
        this.timerStart();
        System.out.println("");
        Scanner input = new Scanner(System.in);
        String needs = input.nextLine();
        needs = needs.toLowerCase();
        int g = 0;
        if (needs.contains("start")) {
            while (g == 0) {
                this.play();
                System.out.println("Play Again?");
                System.out.println("y/n");
                System.out.println("");
                needs = input.nextLine();
                if (needs.toLowerCase().contains("yes") || needs.toLowerCase().equals("y")) {
                    g = 0;

                } else {
                    g = 1;
                    return;
                }
            }
        } else {
            return;
        }
    }
    public static void main(String[] args) {
        Wordle wordle = new Wordle();
        wordle.loop();
    }
}