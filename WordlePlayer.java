
/**
 * Allows the user to play Wordle with graphics.
 * Assumes WordleDictionary and WordleGame are implemented correctly.
 * 
 * YOU DO NOT NEED TO MODIFY THIS CLASS!
 *
 * @author Max Ward
 */
public class WordlePlayer
{
    private WordleDisplay display;
    private WordleGame game;
    private int turn;

    public WordlePlayer()
    {
        display = new WordleDisplay();
        game = new WordleGame(new WordleDictionary().getRandomWord(5));
    }
    
    /**
     * Plays a turn of Wordle.
     */
    public void playTurn(String wordToGuess)
    {
        if (turn >= 6) {
            System.out.println("Game over, the word was: " + game.getSecretWord());
            return;
        }
        String result = game.guessWord(wordToGuess);
        if (result.length() == 0) {
            System.out.println("Incorrect input. Must be a word of length 5");
            return;
        }
        for (int i = 0; i < wordToGuess.length(); ++i) {
            String col;
            if (result.charAt(i) == '*')
                col = "green";
            else if (result.charAt(i) == '.')
                col = "yellow";
            else
                col = "red";
            display.paintLetterSquare(wordToGuess.charAt(i), i*100, turn*100, col);
        }
        turn++;
        System.out.println(wordToGuess);
        System.out.println(result);
        if (turn == 6)
            System.out.println("Game over, the word was: " + game.getSecretWord());
    }
}
