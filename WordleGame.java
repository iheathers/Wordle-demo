/**
 * Manages a single game of Wordle.
 * 
 * You can play Wordle here https://www.nytimes.com/games/wordle/index.html
 * Note that the above game checks each guess is a valid word.
 * We DO NOT do this here! We let the user guess any sequence of 5 characters.
 *
 * @author (Pritam Suwal Shrestha AND 23771397)
 */
public class WordleGame {
    private String secretWord;
    /**
     * Constructs a WordleGame with a specified secret word.
     * 
     * Note that we assume the secretWord contains only lowercase letters ('a'-'z').
     * YOU ARE NOT REQUIRED TO CHECK THIS, JUST ASSUME IT IS TRUE.
     * 
     * Hint: See the secretWord field above.
     */
    public WordleGame(String secretWord)
    {
        // ADDED "this.secretWord" so that that instance variable is not shadowed - Variable Shadowing
                
        this.secretWord = secretWord;
    }
    
    /**
     * Returns the secret word.
     * 
     * Hint: See the secretWord field above.
     */
    public String getSecretWord()
    {
        return secretWord;
    }
    
    /**
     * Returns true if the given letter is in the secret word.
     * For example, if secretWord was "haste" and we called isInSecretWord('e'),
     * then the output would be true because 'e' is in "haste".
     * However, if we called isInSecretWord('z'), then the output would be false.
     * 
     * Hint: Strings have a method called charAt and a method called length.
     *       See https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
     */
    public boolean isInSecretWord(char letter)
    {
        // This could have been implemented by using for loop and charAt method as well. But, indexOf method seems more straightforward  
        
        // indexOf() method returns the "position" of the first occurrence of specified character(s) in a string or "-1" if it never occurs
        // Hence, if result of the method call is -1, it indicates that the character does not exist in the string.
        
        if (secretWord.indexOf(letter) != -1){
            return true;
        }
        return false;
    }
    
    
    /**
     * Takes a word being guessed and outputs a string describing the result of the guess.
     * 
     * If the word to guess has a length different to the secret word, returns an empty string ("")
     * For example, if the secret word is "cat" and we call guessWord("test"), it should return ""
     * because test has a different length than cat.
     * 
     * If the word to guess has the same length as the secret word, returns a string description with that length such that:
     * Each character in the returned string corresponds to a letter in the guess.
     * It should be '*' if the guessed letter at that location is correct.
     * It should be '.' if the guessed letter at that location is not correct, but does appear in the secret word.
     * It should be '_' if the guessed letter at that location is not correct and does not appear in the secret word.
     * 
     * For example, if the secretWord was "diary"
     * guessWord("dandy")
     * would return: "*._.*"
     * 
     * Aliging the strings will help us see which locations match
     * "diary"
     * "dandy"
     * "*._.*"
     * 
     * The first character is '*' because both strings start with a 'd'
     * The second is '.' because 'a' is not the right letter, but is in the secret string.
     * The third is '_' because 'n' does not appear in the secret string.
     * The fourth is '.' because 'd' is not correct, but does appear in the secret string.
     * The fifth is '*' because both strings end with 'y'
     * 
     * Note that we assume the input, wordToGuess, contains only lowercase letters ('a'-'z').
     * YOU ARE NOT REQUIRED TO CHECK THIS, JUST ASSUME IT IS TRUE.
     * 
     * Hint: Use the isInSecretWord method above.
     */
    public String guessWord(String wordToGuess)
    {
        char[] characterArray = new char[wordToGuess.length()]; // This creates an array of characters of length that string wordToGuess has.
        
        // Checks the equality of length of string "secretWord" and "guessed word" and return empty string "" if they are different
        if (this.secretWord.length() != wordToGuess.length()){
            return "";
        }
        
        for (int i = 0; i < wordToGuess.length(); i++){
            if (!isInSecretWord(wordToGuess.charAt(i))){
                characterArray[i] = '_';
            } else {
                if (wordToGuess.charAt(i) == secretWord.charAt(i)){
                    characterArray[i] = '*';
                } else {
                    characterArray[i] = '.';
                }  
            }
        }
        
        // characterArray is an array and not a string. Since, we need to return String in this method, 
        // this converts characterArray to a single string
        String result = new String(characterArray);
        return result;
    }
}
