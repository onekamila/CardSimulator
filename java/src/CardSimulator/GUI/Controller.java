package CardSimulator.GUI;


import CardSimulator.CardDeck.CardDeck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Controller of the <code>GUI</code>. Actually manipulates the <code>CardDeck</code>
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.1
 * @since 1.0.0
 */
public class Controller
{
    private CardDeck cardDeck;
    private GUI gui;
    private InfoPanel infoPanel;


    /**
     * Class constructor
     *
     * @param cardDeck the <code>CardDeck</code> being modeled
     * @param gui the <code>GUI</code> that is being controlled
     */
    public Controller(CardDeck cardDeck, GUI gui)
    {
        this.cardDeck = cardDeck;
        this.gui = gui;
        this.infoPanel = new InfoPanel();

        init();
    }


    private class ShuffleListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            cardDeck.shuffle();
        }
    }

    private class ResetListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            cardDeck.reset();
        }
    }

    private class InfoListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(gui.window, infoPanel, "Info", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private class LinkListener extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent event)
        {
            JHyperLink link = (JHyperLink) event.getSource();
            try
            {
                URI uri = new URI(link.url);

                Desktop desktop = Desktop.getDesktop();
                desktop.browse(uri);
            }
            catch (IOException | URISyntaxException error)
            {
                String errorMessage = "Could not open the link. Error: " + error.getMessage();
                JOptionPane.showMessageDialog(gui.window, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void init()
    {
        gui.shuffleButton.addActionListener((new ShuffleListener()));
        gui.resetButton.addActionListener(new ResetListener());
        gui.infoButton.addActionListener(new InfoListener());

        infoPanel.authorLink.addMouseListener(new LinkListener());
        infoPanel.versionLink.addMouseListener(new LinkListener());
        infoPanel.imagesLink.addMouseListener(new LinkListener());

        cardDeck.addActionListener(gui);
    }


    /**
     * Start the <code>Controller</code>
     */
    public void start()
    {
        gui.start();
    }
}