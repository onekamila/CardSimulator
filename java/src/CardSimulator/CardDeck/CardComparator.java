package CardSimulator.CardDeck;


import java.util.Comparator;


/**
 * Compares two <code>Card</code>s based on <code>Suit</code> and <code>Rank</code>
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.1
 * @since 1.0.0
 */
public class CardComparator implements Comparator<Card>
{
    @Override
    /**
     * Compares the given <code>Card</code>s
     */
    public int compare(Card card1, Card card2)
    {
        if(card1.suit == card2.suit)
        {
            return card1.rank.compareTo(card2.rank);
        }
        else
        {
            return card1.suit.compareTo(card2.suit);
        }
    }
}