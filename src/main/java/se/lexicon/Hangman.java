package se.lexicon;
import java.util.Arrays;
public class Hangman{

    //Hangman variables
    // choose a secret word
    String secretWord="isabel";
    char[] dashes=new char[secretWord.length()];


    int numberOfGuesses=8;
    int numOfExistedLetters=0;
    int numOfFaultGuesses=0;
    boolean win=false;

    //Constructor
    public  Hangman()
    {
        Arrays.fill(dashes,'-');
    }
    // Show dashes to the player
    public void showDashesToPlayer(){
        for (int i=0;i<secretWord.length();i++){
            System.out.print(dashes[i]);
        }
    }
    //
    //Send a message to player to guess a letter
    public void askPlayerToGuess(int numberOfGuesses){
        System.out.println("\nGuess a letter"+ ", you have "+numberOfGuesses +" left");
    }
    public boolean checkGussLetter(String  letter) {
        boolean letterIsExist=false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i)==letter.charAt(0))
            {
                letterIsExist=true;
                dashes[i]=letter.charAt(0);
                numOfExistedLetters +=1;
            }//End if
        }//End loop

        if (letterIsExist)
        {
            System.out.println("The letter is in the secret word");
        }
        else {
            System.out.println("The letter is not in the secret word");
            numOfFaultGuesses +=1;
        }
        return letterIsExist;
    }//End method

    public boolean isPlayerWin(int numOfExistedLetters) {
        if (numOfExistedLetters==secretWord.length())
        { return true; }
        else {return false;}
    }

}
