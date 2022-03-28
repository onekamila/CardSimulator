package CardSimulator.CardDeck;


/**
 * Represents a playing card
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public class Card
{
    private static boolean initRan = false; // Whether the class has been initialized
    /**
     * <code>Comparator</code> used to compare two <code>Cards</code>
     */
    protected static CardComparator cardComparator;
    /**
     * The <code>Suit</code> of the <code>Card</code>
     */
    public Suit suit;
    /**
     * The <code>Rank</code> of the <code>Card</code>
     */
    public Rank rank;


    /**
     * Class constructor
     *
     * @param suit the <code>Suit</code> of the <code>Card</code>
     * @param rank the <code>Rank</code> of the <code>Card</code>
     */
    public Card(Suit suit, Rank rank)
    {
        this.suit = suit;
        this.rank = rank;
        init();
    }

    private static void init()
    {
        if(!initRan)
        {
            cardComparator = new CardComparator();
            initRan = true;
        }
    }


    /**
     * Compare if a given <code>Card</code> is equal to the other
     *
     * @param other the <code>Card</code> to be compared
     * @return <code>true</code> if they are the same, <code>false</code> otherwise
     */
    public boolean equals(Card other)
    {
        return (this.compare(other) == 0);
    }

    /**
     * Compare a given <code>Card</code> with this one
     *
     * @param other the <code>Card</code> to be compared
     * @return a negative integer if the given <code>Card</code> is less than this one, zero if they are equal, or a
     *         positive integer if the given <code>Card</code> is greater than this one
     */
    public int compare(Card other)
    {
        return cardComparator.compare(this, other);
    }

    /**
     * <code>String</code> representation
     *
     * @return the <code>String</code> representation of this <code>Card</code>
     */
    public String toString()
    {
        return (suit.toString() + rank.toString());
    }
}
