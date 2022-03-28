package CardSimulator.CardDeck;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


/**
 * Represents a deck of cards
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public class CardDeck extends ArrayList<Card>
{
    private static Random random;
    private ArrayList<ActionListener> actionListeners;


    /**
     * Class constructor
     */
    public CardDeck()
    {
        super();
        init();
        newDeck();
    }

    private void init()
    {
        if(random == null)
        {
            random = new Random();
        }
        actionListeners = new ArrayList<ActionListener>();
    }

    private void newDeck()
    {
        for(Suit suit: Suit.values())
        {
            for(int i = 0; i < Rank.values().length; i++)
            {
                Rank rank = Rank.values()[i];
                super.add(new Card(suit, rank));
            }
        }
    }


    /**
     * Shuffles this <code>CardDeck</code>
     */
    public void shuffle()
    {
        ArrayList<ArrayList<Card>> halves = splitDeck();
        recombineDecks(halves.get(0), halves.get(1));

        ActionEvent shuffleEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "deck shuffled");
        processEvent(shuffleEvent);
    }

    private ArrayList<ArrayList<Card>> splitDeck()
    {
        ArrayList<ArrayList<Card>> halves = new ArrayList<ArrayList<Card>>();
        ArrayList<Card> topHalf;
        ArrayList<Card> bottomHalf;

        int middle = (random.nextInt(12) + 20);
        topHalf = new ArrayList<Card>(super.subList(0, middle));
        bottomHalf = new ArrayList<Card>(super.subList(middle, (super.size())));

        halves.add(topHalf);
        halves.add(bottomHalf);
        return halves;
    }

    private void recombineDecks(ArrayList<Card> leftHalf, ArrayList<Card> rightHalf)
    {
        super.clear();

        boolean chooseLeft;

        while(!leftHalf.isEmpty() && !rightHalf.isEmpty())
        {
            chooseLeft = random.nextBoolean();

            if(chooseLeft)
            {
                super.add(0, leftHalf.remove(leftHalf.size() - 1));
            }
            else
            {
                super.add(0, rightHalf.remove(rightHalf.size() - 1));
            }
        }

        if(leftHalf.isEmpty())
        {
            super.addAll(0, rightHalf);
        }
        else
        {
            super.addAll(0, leftHalf);
        }
    }

    /**
     * Resets the order of the <code>Card</code>s into the original order
     */
    public void reset()
    {
        super.sort(Card.cardComparator);
        ActionEvent resetEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "deck reset");
        processEvent(resetEvent);
    }


    public synchronized void addActionListener(ActionListener listener)
    {
        actionListeners.add(listener);
    }

    protected synchronized void removeActionListener(ActionListener listener)
    {
        actionListeners.remove(listener);
    }

    private void processEvent(ActionEvent e)
    {
        ArrayList<ActionListener> listenerList;

        synchronized (this)
        {
            listenerList = (ArrayList<ActionListener>) actionListeners.clone();
        }

        for(ActionListener listener: listenerList)
        {
            listener.actionPerformed(e);
        }
    }
}
