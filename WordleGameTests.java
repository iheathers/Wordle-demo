import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Tests for WordleGame.
 * For use with the CITS1001 2022 Semester 2 project.
 * If you pass all tests, you are (almost certainly) going to get full marks for correctness (but maybe not everything else).
 * 
 * YOU DO NOT NEED TO MODIFY THESE TESTS!
 *
 * @author  Max Ward
 */
public class WordleGameTests
{    
    @Test
    public void testConstructor()
    {
        WordleGame game = new WordleGame("string");
        game = new WordleGame("");
        game = new WordleGame("veryveryverylongword");
    }
    
    
    @Test
    public void testGetSecretWord()
    {
        WordleGame game = new WordleGame("games");
        assertEquals("games", game.getSecretWord());
        game = new WordleGame("test");
        assertNotEquals("games", game.getSecretWord());
    }
    
    
    @Test
    public void testIsInSecretWord()
    {
        WordleGame game = new WordleGame("games");
        assertTrue(game.isInSecretWord('e'));
        assertTrue(game.isInSecretWord('g'));
        assertTrue(game.isInSecretWord('a'));
        assertFalse(game.isInSecretWord('z'));
        assertFalse(game.isInSecretWord('y'));
    }
    
    @Test
    public void testGuessWord()
    {
        WordleGame game = new WordleGame("games");
        assertEquals("_____", game.guessWord("xyzfu"));
        assertEquals(".___.", game.guessWord("abcde"));
        assertEquals("*___.", game.guessWord("groom"));
        assertEquals("****_", game.guessWord("gamey"));
        assertEquals("*....", game.guessWord("ggggg"));
        assertEquals("", game.guessWord(""));
        assertEquals("games", game.getSecretWord());
        assertEquals("", game.guessWord("gamess"));
        assertEquals("*****", game.guessWord("games"));
        assertEquals("*****", game.guessWord("games"));
        assertEquals("", game.guessWord("xxa"));
        
        game = new WordleGame("dairy");
        assertEquals("_*.**", game.guessWord("marry"));
        assertEquals("_*.**", game.guessWord("marry"));
        assertEquals("_*.**", game.guessWord("marry"));
        assertEquals("", game.guessWord("airy"));
        assertEquals("..**.", game.guessWord("iiirr"));
        
        game = new WordleGame("zazzy");
        assertEquals("*.**.", game.guessWord("zzzzz"));
        assertEquals("_._._", game.guessWord("xyxyx"));
        assertEquals("", game.guessWord("x"));
        assertEquals("", game.guessWord(""));
        assertEquals("", game.guessWord("adsrsx"));
    }
}
