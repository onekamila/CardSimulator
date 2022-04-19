package CardSimulator.GUI;


import CardSimulator.CardDeck.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/**
 * <code>JComponent</code> upon which all <code>CardGraphics</code> are drawn
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public class CardPanel extends JComponent
{
    private static final int OFFSET = 17;
    private static final int WIDTH = 983;
    private static final int HEIGHT = 180;

    private HashMap<Card, CardGraphic> cardMap;
    private ArrayList<CardGraphic> cardGraphics;


    /**
     * Class constructor
     *
     * @param cardDeck the <code>CardSimulator.CardSimulator.CardDeck</code> to base the <code>CardGraphics</code>
     * @throws IOException if an error occurs while trying to read an image file
     */
    public CardPanel(CardDeck cardDeck) throws IOException, URISyntaxException
    {
        init(cardDeck);
    }


    private void init(CardDeck cardDeck) throws IOException, URISyntaxException
    {
        ArrayList<ImageIcon> imageIcons = new ArrayList<>();

        for(Suit suit: Suit.values())
        {
            imageIcons.addAll(ImageReader.getImages(suit));
        }

        cardGraphics = new ArrayList<CardGraphic>();
        cardMap = new HashMap<Card, CardGraphic>();

        for(int i = 0; i < cardDeck.size(); i++)
        {
            Card card = cardDeck.get(i);
            ImageIcon imageIcon = imageIcons.get(i);
            CardGraphic cardGraphic = new CardGraphic(imageIcon);
            cardMap.put(card, cardGraphic);
            cardGraphics.add(0, cardGraphic);
        }

        setSize(WIDTH, HEIGHT);
    }


    private void getCardGraphics(CardDeck cardDeck)
    {
        cardGraphics.clear();

        for(Card card: cardDeck)
        {
            CardGraphic cardGraphic = cardMap.get(card);
            cardGraphics.add(cardGraphic);
        }

        Collections.reverse(cardGraphics);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int x = 5;
        int y = 5;

        for (CardGraphic cardGraphic : cardGraphics)
        {
            cardGraphic.setPosition(x, y);
            cardGraphic.draw(g, this);
            x += OFFSET;
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }

    /**
     * Update the CardSimulator.CardSimulator.GUI to match the state of the given <code>CardSimulator.CardSimulator.CardDeck</code>
     *
     * @param cardDeck the <code>CardSimulator.CardSimulator.CardDeck</code> to match
     */
    public void update(CardDeck cardDeck)
    {
        getCardGraphics(cardDeck);

        this.repaint();
    }
}