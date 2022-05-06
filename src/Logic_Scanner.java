import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Logic_Scanner {
    public static void main(String[] args) {
        // gameMethod();
        testerMethod("randr");
    }

    // (tester)
    // System.out.println(words);

<<<<<<< HEAD
public static ArrayList wordExtractor(){
=======
 public ArrayList <String> wordExtractor(){
>>>>>>> 7a8caf7e85c27425f540df856db776903e1d68f4
        ArrayList<String> words = new ArrayList<String>();
        Scanner sc = null; 

        try {
            sc = new Scanner(new FileReader("dict.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String str; 
        // checking end of file
        while (sc.hasNext()) {
            str = sc.next(); 
            System.out.println(str);
            // adding each string to arraylist
            words.add(str.toLowerCase());
            
        }
        return words; 
        }

<<<<<<< HEAD
public static void gameMethod() {
        ArrayList<String> useless = wordExtractor(); 
        String word = useless.get((int)(Math.random() * useless.size()));
=======
    public static void gameMethod() {
        ArrayList<String> useless = new ArrayList<String>();
        String word = useless.get((int) (Math.random() * useless.size()));
>>>>>>> 7a8caf7e85c27425f540df856db776903e1d68f4
        Scanner input = new Scanner(System.in);
        int g = 0;
        String guess = "";
        // System.out.println(word); //tester
        System.out.println("Enter your first guess!");
        while (guess != word) {
            if (g == 6) {
                System.out.println("TOO MANY GUESSES! Looser looser cock brunch. The answer was " + word + ".");
                break;
            }
            guess = input.nextLine(); // works as intended
            if (guess.equals(word)) {
                System.out.println("You got it in " + (g + 1) + " guess(es). Game over. Winner winner chicken dinner");
                break;
            } else if (guess.length() != 5) {
                System.out.println("Must be 5 letters!");

            } else {
                g++;
                int x = 0;
                for (int i = 0; i < guess.length(); i++) {
                    for (int j = 0; j < word.length(); j++) {
                        if (guess.substring(i, i + 1).equals(word.substring(j, j + 1))) {
                            x++;
                            if (j == i) {
                                System.out.println(
                                        "The guess " + guess.substring(i, i + 1) + " is correct and in the right spot");

                                // temp code to be replaced with GUI
                                // does not work for double letters
                            } else {
                                System.out.println("The guess " + guess.substring(i, i + 1)
                                        + " is correct, but in the wrong spot");
                            }
                        }
                    }
                }
                if (x == 0) {
                    System.out.println("you got nothing right, die in hell"); // if none of the letters are correct
                }
<<<<<<< HEAD
            }  } } //end gameMethod 

            public static void testerMethod(String tester) { //like gameMethod, but with a word we decide for testing purposes
            Scanner input = new Scanner(System.in);
                String word = tester; 
                int g = 0;
                String guess = "";
                System.out.println(word); //tester
                System.out.println("Enter your first guess!");
                    while (guess != word){
                        if(g == 6){
                            System.out.println("TOO MANY GUESSES! Looser looser cock brunch. The answer was " + word + ".");
                            break; 
                        }
                        guess = input.nextLine(); //works as intended
                        if(guess.equals(word)){
                            System.out.println("You got it in " + (g+1) + " guess(es). Game over. Winner winner chicken dinner");
                            break; 
                        }
                       else if (guess.length()!=5){
                            System.out.println("Must be 5 letters!");
            
                        }
                    else {
                        g++; 
                        int x = 0; 
                       for (int i = 0; i < guess.length(); i++){
                           for(int j = 0; j <word.length(); j++){
                               if(guess.substring(i, i+1).equals(word.substring(j, j+1))){
                                   x++; 
                                   if(j == i){
                                    System.out.println("The guess " + guess.substring(i, i+1) + " is correct and in the right spot");
                                    
                                    //temp code to be replaced with GUI 
                                    //does not work for double letters
                                   }
                                   else{
                                   System.out.println("The guess " + guess.substring(i, i+1) + " is correct, but in the wrong spot");} 
                                }                            
                            }
                        }
                        if(x == 0){System.out.println("you got nothing right, die in hell"); }
                    }  } } //end gameTester 
=======
            }
        }
    } // end gameMethod
>>>>>>> 7a8caf7e85c27425f540df856db776903e1d68f4

    public static void testerMethod(String tester) { // like gameMethod, but with a word we decide for testing purposes
        Scanner input = new Scanner(System.in);
        String word = tester;
        int g = 0;
        String guess = "";
        System.out.println(word); // tester
        System.out.println("Enter your first guess!");
        while (guess != word) {
            if (g == 6) {
                System.out.println("TOO MANY GUESSES! Looser looser cock brunch. The answer was " + word + ".");
                break;
            }
            guess = input.nextLine(); // works as intended
            if (guess.equals(word)) {
                System.out.println("You got it in " + (g + 1) + " guess(es). Game over. Winner winner chicken dinner");
                break;
            } else if (guess.length() != 5) {
                System.out.println("Must be 5 letters!");

            } else {
                g++;
                int x = 0;
                for (int i = 0; i < guess.length(); i++) {
                    for (int j = 0; j < word.length(); j++) {
                        if (guess.substring(i, i + 1).equals(word.substring(j, j + 1))) {
                            x++;
                            if (j == i) {
                                System.out.println(
                                        "The guess " + guess.substring(i, i + 1) + " is correct and in the right spot");

                                // temp code to be replaced with GUI
                                // does not work for double letters
                            } else {
                                System.out.println("The guess " + guess.substring(i, i + 1)
                                        + " is correct, but in the wrong spot");
                            }
                        }
                    }
                }
                if (x == 0) {
                    System.out.println("you got nothing right, die in hell");
                }
            }
        }
    } // end gameTester

}
