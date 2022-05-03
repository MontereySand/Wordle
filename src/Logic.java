import java.util.Scanner;

public class Logic {
    public static void main(String[] args) {

        String[] words = { "hello", "broke", "money", "nigel", "super" }; // will later tap into the text file and pull from there
                                                                          // find out how do that...perferebly in a lightweight manner
        String word = words[(int) (Math.random() * words.length)];  //gets random int and asks for that int as an index in words[]    
        System.out.println(word);    
        Scanner input = new Scanner(System.in);

        String guess = "";
        System.out.println("Enter your first guess!");
        while (guess != word){
            guess = input.nextLine(); //works as intended
            if (guess.length()!=5){
                System.out.println("Must be 5 letters!");
                continue; 

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
                       // need a way to check if all of the letters are in the right spot - from Krrish
                       // need to add which letters are not correct at all - from Krrish
                       }
                       
                   }
               

           }
        }
            
        }
    }
}

//this is possibly not an issue but the terminal needs to be erased before every reboot 
//probbaly is an issue