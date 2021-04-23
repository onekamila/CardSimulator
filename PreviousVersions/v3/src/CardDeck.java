import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a standard deck of playing cards.
 *
 * @author Garrett Kamila Crayton
 * @version 1.0
 */
public class CardDeck
{
    /**
     * The "deck" of <code>Cards</code>
     */
    public ArrayList<Card> cards;
    private static Random random;

    /**
     * Construct a new CardDeck object.
     */
    public CardDeck()
    {
        init();
        newDeck();
    }

    /**
     * Initialize the class attributes (if necessary
     */
    private static void init()
    {
        if(random == null)
        {
            random = new Random();
        }
    }

    /**
     * Generate a new deck of cards.
     */
    private void newDeck()
    {
        cards = new ArrayList<Card>();
        for(Suit suit: Suit.values())
        {
            for(Rank rank: Rank.values())
            {
                cards.add(new Card(suit, rank));
            }
        }
    }

    /**
     * Shuffle the cards in the deck in a realistic manner.
     */
    public void shuffle()
    {
        // Split the deck
        ArrayList<ArrayList> halves = splitDeck();

        // Recombine the decks
        recombineDecks(halves.get(0), halves.get(1));
    }

    /**
     * Split the deck of cards roughly in half.
     *
     * @return  ArrayList containing both halves of the original deck
     */
    private ArrayList<ArrayList> splitDeck()
    {
        ArrayList<ArrayList> halves = new ArrayList<ArrayList>();
        ArrayList<Card> topHalf;
        ArrayList<Card> bottomHalf;

        int middle = (random.nextInt(12) + 20);
        topHalf = new ArrayList<Card>(cards.subList(0, middle));
        bottomHalf = new ArrayList<Card>(cards.subList(middle, cards.size()));

        halves.add(topHalf);
        halves.add(bottomHalf);

        return halves;
    }

    /**
     * Recombines both halves into one whole deck.
     *
     * @param leftHalf      one of the two "halves" of the original deck
     * @param rightHalf     the other "half" of the original deck
     */
    private void recombineDecks(ArrayList<Card> leftHalf, ArrayList<Card> rightHalf)
    {
        cards.clear();

        while((leftHalf.size() != 0) && (rightHalf.size() != 0))
        {
            boolean choseLeft = random.nextBoolean();

            if(choseLeft)
            {
                cards.add(0, leftHalf.remove(leftHalf.size() - 1));
            }
            else
            {
                cards.add(0, rightHalf.remove(rightHalf.size() - 1));
            }
        }

        if(leftHalf.isEmpty())
        {
            cards.addAll(0, rightHalf);
        }
        else
        {
            cards.addAll(0, leftHalf);
        }
    }

    /**
     * Reset the deck (sort cards into original order)
     */
    public void reset()
    {
        cards.sort(Card.comparator);
    }

    /**
     * String representation of the deck of cards
     *
     * @return  the string representation of the deck of cards
     */
    public String toString()
    {
        return cards.toString();
    }
}
