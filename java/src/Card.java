import java.util.Comparator;

/**
 * Represents a playing card
 */
public class Card
{
    private static boolean initRan;
    protected static CardComparator comparator;
    protected Suit suit;
    protected Rank rank;

    /**
     * The process for comparing two <code>Cards</code> (used for sorting).
     *
     * @author Garrett Kamila Crayton
     * @version 1.0
     */
    private static class CardComparator implements Comparator<Card>
    {
        /**
         * Compare the two given cards.
         *
         * @param card1 the card being compared against
         * @param card2 the card being compared to
         * @return      a negative integer, zero, or positive integer depending on whether card1 is less
         *              than, equal to, or greater than card2
         */
        public int compare(Card card1, Card card2)
        {
            int compare;
            if(card1.suit == card2.suit)
            {
                compare = card1.rank.compareTo(card2.rank);
            }
            else
            {
                compare = card1.suit.compareTo(card2.suit);
            }
            return compare;
        }
    }

    /**
     * Constructs a new <code>Card</code> object
     *
     * @param suit  the <code>Suit</code> of the <code>Card</code>
     * @param rank  the <code>Rank</code> of the <code>Card</code>
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
            initRan = true;
            comparator = new CardComparator();
        }
    }

    /**
     * Return the string representation of this <code>Card</code>.
     * <p>
     * This method simply returns the combination of the string representation of the
     * card's <code>Suit</code> and the string representation of the card's <code>Rank</code>.
     *
     * @return  the string representation of the <code>Card</code>
     */
    public String toString()
    {
        return (suit.toString() + rank.toString());
    }
}
