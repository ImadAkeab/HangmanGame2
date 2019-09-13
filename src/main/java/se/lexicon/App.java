package se.lexicon;
import java.util.Arrays;
import java.util.Scanner;


public class App 
{
    public  static Scanner scanner=new Scanner(System.in);

    public static void main( String[] args )
    {
        boolean keepPlaying = true;

        while (keepPlaying) {
            startGame();
            keepPlaying = DoYouPlayAgain();
        }
    }//End main

    private static boolean DoYouPlayAgain() {
        System.out.println("Select 1 to play again and 2 to quit\n");
        int playerSelect=scanner.nextInt();
        switch (playerSelect){
            case 1:
                return true;
            case 2:
                return false;
        }
        return false;
    }
    public static void startGame(){
        Hangman hangman=new Hangman();
        StringBuilder alreadyGuessedLetters=new StringBuilder();
        int guessNum=0;
        while (guessNum < hangman.numberOfGuesses){
            hangman.showDashesToPlayer();

            // Ask player to guess a letter.
            hangman.askPlayerToGuess(hangman.numberOfGuesses-guessNum);

            //Player input a guessed letter
            String inputUser = scanner.nextLine();
            if (inputUser.length() < 1)
            {
                //not a guess
                continue;
            }
            else if (inputUser.length() == 1)
            {
                //letter check
                // check if the guessed letter guessed by the player and ask him to chose another one.
                if(alreadyGuessedLetters.toString().contains(inputUser))
                {
                    System.out.println("Player already guessed this letter :"+ alreadyGuessedLetters.toString());
                    continue;
                }
                // Save guessed letters in a string.
                alreadyGuessedLetters.append(inputUser).append(' ');
                // check if the guessed letter is exist in the secret word.
                hangman.checkGussLetter(inputUser);
                if (hangman.isPlayerWin(hangman.numOfExistedLetters)){
                    System.out.println("You win!");
                    break;
                }
            }
            else
            {
                // Word Check
                if(hangman.secretWord.length()< inputUser.length()){
                    System.out.println("the word is shorter than the secret word");
                }
                else{
                    if (hangman.secretWord.contentEquals(inputUser)){
                        System.out.println("You win!");
                        break;
                    }
                    else{
                        System.out.println("Incorrect guess");
                    }
                }

            }
            guessNum++;
        }//End while
    }

}
