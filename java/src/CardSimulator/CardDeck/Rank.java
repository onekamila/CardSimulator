package CardSimulator.CardDeck;


/**
 * Represents a card's rank
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public enum Rank
{
    /**
     * <code>Card</code> with a rank of Ace
     */
    ACE("A", 1),
    /**
     * <code>Card</code> with a rank of 2
     */
    TWO("2", 2),
    /**
     * <code>Card</code> with a rank of 3
     */
    THREE("3", 3),
    /**
     * <code>Card</code> with a rank of 4
     */
    FOUR("4", 4),
    /**
     * <code>Card</code> with a rank of 5
     */
    FIVE("5", 5),
    /**
     * <code>Card</code> with a rank of 6
     */
    SIX("6", 6),
    /**
     * <code>Card</code> with a rank of 7
     */
    SEVEN("7", 7),
    /**
     * <code>Card</code> with a rank of 8
     */
    EIGHT("8", 8),
    /**
     * <code>Card</code> with a rank of 9
     */
    NINE("9", 9),
    /**
     * <code>Card</code> with a rank of 10
     */
    TEN("10", 10),
    /**
     * <code>Card</code> with a rank of Jack
     */
    JACK("J", 11),
    /**
     * <code>Card</code> with a rank of Queen
     */
    QUEEN("Q", 12),
    /**
     * <code>Card</code> with a rank of King
     */
    KING("K", 13);


    private final String displayValue;
    public final int rankValue;


    private Rank(String displayValue, int rankValue)
    {
        this.displayValue = displayValue;
        this.rankValue = rankValue;
    }


    /**
     * Returns the <code>String</code> representation of the <code>Rank</code>
     *
     * @return <code>String</code> representation of the <code>Rank</code>
     */
    public String toString()
    {
        return displayValue;
    }
}