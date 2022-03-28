package CardSimulator.CardDeck;


import java.util.Comparator;


/**
 * Compares two cards based on suit and rank
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public class CardComparator implements Comparator<Card>
{
    @Override
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