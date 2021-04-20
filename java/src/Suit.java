import java.nio.charset.Charset;

/**
 * Represents a card's suit.
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public enum Suit
{
    SPADES("\u2660".charAt(0), 'S'),
    DIAMONDS("\u2666".charAt(0), 'D'),
    CLUBS("\u2663".charAt(0), 'C'),
    HEARTS("\u2665".charAt(0), 'H');

    /**
     * The character value of the <code>Suit</code>
     */
    private final char displayValue;

    Suit(char displayValue, char altValue)
    {
        if(Charset.defaultCharset().toString().equals("UTF-8"))
        {
            this.displayValue = displayValue;
        }
        else
        {
            this.displayValue = altValue;
        }
    }

    /**
     * Return the string representation of the <code>Suit</code> object. <br>
     * If the encoding used is UTF-8, then the corresponding suit symbol is used.
     * Otherwise, the first letter of the suit's name is used.
     *
     * @return  the string representation of the <code>Suit</code>>
     */
    public String toString()
    {
        return Character.toString(displayValue);
    }
}