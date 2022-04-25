import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {

        String[] words = { "hello", "broke", "money", "cocks", "penis" };
        String word = words[(int) (Math.random() * words.length)];
        Scanner input = new Scanner(System.in);
        int g = 6;
        String guess = "";
        while (guess != word) {
            // guess = input.nextLine();
            // if (guess.length!=5){
            //     System.out.println("Must be 5 Chars");
            // }
            // for (int i = 0){

            // }
        }
    }
}