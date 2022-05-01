import java.util.Scanner;

public class Logic {
    public static void main(String[] args) {

        String[] words = { "hello", "broke", "money", "nigel", "super" }; // will later tap into the text file and pull from there
                                                                          // find out how do that...perferebly in a lightweight manner
        String word = words[(int) (Math.random() * words.length)]; // for Guilia from col 29-65 in this line, all it does is change it to an INT, i'm not too sure how that makes sense
                                                                   // for Guilia its just makeing x as an int, its making "String word = words[x]" I don't get how this works lmaoo, maybe this is not it's final form
        Scanner input = new Scanner(System.in);
        int g = 6;
        String guess = "";
        System.out.println("Enter your first guess!");
        while (guess != word){
            guess = input.nextLine(); //works as intended
            if (guess.length()!=5){
                System.out.println("Must be 5 letters!");

            }
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

//this is possibly not an issue but the terminal needs to be erased before every reboot 
//probbaly is an issue