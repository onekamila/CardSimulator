package CardSimulator.CardDeck;


import java.nio.charset.Charset;


/**
 * Represents a suit of a card
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public enum Suit
{
    /**
     * <code>Card</code> with the suit Spades
     */
    SPADES('\u2660', 'S'),
    /**
     * <code>Card</code> with the suit Diamonds
     */
    DIAMONDS('\u2666', 'D'),
    /**
     * <code>Card</code> with the suit Clubs
     */
    CLUBS('\u2663', 'C'),
    /**
     * <code>Card</code> with the suit Hearts
     */
    HEARTS('\u2665', 'H');


    private final char displayValue;


    private Suit(char displayValue, char altValue)
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
     * Returns the <code>String</code> representation of the <code>Suit</code>
     *
     * @return <code>String</code> representation of the <code>Suit</code>
     */
    public String toString()
    {
        return Character.toString(displayValue);
    }
}
