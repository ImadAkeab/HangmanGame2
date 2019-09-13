package se.lexicon;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     *
     */
    Hangman hangman=new Hangman();
    @Test
    public void checkGuessLetterTrue()
    {
        Assert.assertTrue(hangman.checkGussLetter("s"));
    }

    @Test
    public void checkGuessLetterFalse()
    {
        Assert.assertFalse(hangman.checkGussLetter("m"));
    }


    //////
    @Test
    public void checkGuessWordTrue()
    {
        Assert.assertTrue(hangman.secretWord.contentEquals("isabel"));
    }

    @Test
    public void checkGuessWordFalse()
    {
        Assert.assertFalse(hangman.secretWord.contentEquals("stable"));
    }

    ////
    @Test
    public void isPlayerWinTrue()
    {
        Assert.assertTrue(hangman.isPlayerWin(6));
    }

    @Test
    public void isPlayerWinFalse()
    {
        Assert.assertFalse(hangman.isPlayerWin(5));
    }

}
