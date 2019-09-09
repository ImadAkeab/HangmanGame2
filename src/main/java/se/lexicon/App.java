package se.lexicon;
import java.util.Arrays;
import java.util.Scanner;


public class App 
{
    public  static Scanner scanner=new Scanner(System.in);

    public static void main( String[] args )
    {
        Player player=new Player();
        player.play=true;
        while (player.play) {
            startGame(player);
            DoYouPlayAgain(player);
        }
    }//End main

    private static void DoYouPlayAgain(Player player) {
        System.out.println("Select 1 to play again and 2 to quit\n");
        int playerSelect=scanner.nextInt();
        switch (playerSelect){
            case 1:
                player.play=true ;
                break;
            case 2:
                player.play=false;
                break;
        }
    }
    public static void startGame(Player player){
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
                alreadyGuessedLetters.insert(guessNum,inputUser);
                // check if the guessed letter is exist in the secret word.
                hangman.checkGussLetter(inputUser);
                if (hangman.isPlayerWin(inputUser)){
                    System.out.println("You win!");
                    break;
                }
            }
            else
            {
                // Word Check
                if(hangman.secretWord.length()< inputUser.length()){
                    System.out.println("the word is shorter than the secret tword");
                }
                else{
                    if (hangman.secretWord.contentEquals(inputUser)){
                        System.out.println("You win!");
                        break;
                    }
                    else{
                        System.out.println("Game is over");
                        break;
                    }
                }


            }
            guessNum++;
        }//End while
    }

}
