import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Tests for WordleDictionary.
 * For use with the CITS1001 2022 Semester 2 project.
 * If you pass all tests, you are (almost certainly) going to get full marks for correctness (but maybe not everything else).
 * 
 * YOU DO NOT NEED TO MODIFY THESE TESTS!
 *
 * @author  Max Ward
 */
public class WordleDictionaryTests
{
    @Test
    public void testGetWordsWithLength()
    {
        WordleDictionary dictionary = new WordleDictionary();
        ArrayList<String> words = dictionary.getWordsWithLength(5);
        assertEquals(1373, words.size());
        assertEquals("abuse", words.get(3));
        assertEquals("alarm", words.get(22));
        assertEquals("voted", words.get(1300));
        words = dictionary.getWordsWithLength(6);
        assertEquals(1502, words.size());
    }
    
    @Test
    public void testGetRandomWord()
    {
        WordleDictionary dictionary = new WordleDictionary();
        String randomWord = dictionary.getRandomWord(5);
        int count = 0;
        for (String word : dictionary.getWordsWithLength(5)) {
            if (word.equals(randomWord))
                ++count;
        }
        assertEquals(1, count);
        count = 0;
        for (int i = 0; i < 100; i++) {
            String randomWord2 = dictionary.getRandomWord(5);
            if (!randomWord2.equals(randomWord))
                ++count;
        }
        assertTrue(0 < count);
    }
}
