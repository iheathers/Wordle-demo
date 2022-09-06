import java.awt.*;
import java.util.*;
import java.awt.event.*;

/**
 * Canvas for displaying a Wordle Game.
 * Created for use in the CITS1001 2022 S2 Project.
 * 
 * YOU DO NOT NEED TO MODIFY THIS CLASS!
 *
 * @author Max Ward
 */
public class WordleDisplay
{

    private Frame f;
    private WordleCanvas c;

    class WordleCanvas extends Canvas
    {
        public void paintGuessLetter(Graphics g, char letter, int x, int y, Color color)
        {
            g.setColor(color);
            g.fillRect(x, y, 100, 100);
            g.setColor(Color.black);
            g.drawString(new String(new char[]{letter}), x+50, y+50);
        }
    }

    public WordleDisplay()
    {
        f = new Frame("CITS1001 Wordle");
        c = new WordleCanvas();
        f.add(c);
        f.setSize(520, 640);
        f.setVisible(true);
        f.setResizable(false);
        f.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }
        });
    }

    public void paintLetterSquare(char letter, int x, int y, String colour)
    {
        Color col = null;
        if (colour == "red")
            col = Color.red;
        if (colour == "green")
            col = Color.green;
        if (colour == "yellow")
            col = Color.yellow;
        if (col == null) {
            System.out.println("colour not recognised: " + colour);
            return;
        }
        c.paintGuessLetter(c.getGraphics(), letter, x, y, col);
    }
}
