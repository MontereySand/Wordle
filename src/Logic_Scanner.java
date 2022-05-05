import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Logic_Scanner {
    public static void main(String[] args) {
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
            // adding each string from dict.txt to arraylist
            words.add(str.toLowerCase());
       
            
        }

        //(tester) 
        //System.out.println(words); 

        String word = words.get((int)(Math.random() * words.size()));
        Scanner input = new Scanner(System.in);
        String wordTester = "hello";
        int g = 6;
        String guess = "";
        System.out.println(word); //tester, tells us what the word is so we can simulate a game 
        System.out.println("Enter your first guess!");
        
        while (guess != wordTester){

            guess = input.nextLine(); //works as intended
            if(guess.equals(word)){
                System.out.println("You got it. Game over. Winner winner chicken dinner");
                break; 
                //solves terminal issue 
            }
           else if (guess.length()!=5){
                System.out.println("Must be 5 letters!");

            }
        else {
           for (int i = 0; i < guess.length(); i++){
               for(int j = 0; j <word.length(); j++){
                   if(guess.substring(i, i+1).equals(word.substring(j, j+1))){
                    
                    
                       if(j == i){
                        System.out.println("The guess " + guess.substring(i, i+1) + " is correct and in the right spot");
                        
                        //temp code to be replaced with GUI 
                        //does not work for double letters
                       }
                       else{
                       System.out.println("The guess " + guess.substring(i, i+1) + " is correct, but in the wrong spot");
                       //temp code to be replaced with GUI
                       //does not work for double letters
                       
                       }
                       
                   }
               }

           }
        }
            
        }
    }
}
<<<<<<< HEAD
=======

>>>>>>> 323e1ebe1dc857d936746c0d87fb2fffbb0a857a
