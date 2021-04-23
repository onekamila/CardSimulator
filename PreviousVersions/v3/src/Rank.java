/**
 * Represents a playing card's rank
 *
 * @author Garrett Kamila Crayton
 * @version 1.0
 */
public enum Rank
{
    ACE("A", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13);

    private final String displayValue;
    protected final int rankValue;

    Rank(String displayValue, int rankValue)
    {
        this.displayValue = displayValue;
        this.rankValue = rankValue;
    }

    /**
     * Return the string representation of the <code>Rank</code> object.
     *
     * @return  the string representation of the <code>Rank</code> object
     */
    public String toString()
    {
        return this.displayValue;
    }
}
