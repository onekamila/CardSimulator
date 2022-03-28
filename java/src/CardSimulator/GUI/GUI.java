package CardSimulator.GUI;

import CardSimulator.CardDeck.CardDeck;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * The Graphical User Interface (CardSimulator.CardSimulator.GUI) of the simulation
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public class GUI implements ActionListener
{
    private static final Color DARK_GREEN = new Color(0, 153, 0);

    protected JFrame window;
    protected JPanel mainPanel;
    protected JButton infoButton;
    protected JButton shuffleButton;
    protected JButton resetButton;
    protected CardPanel cardPanel;


    /**
     * Class constructor
     *
     * @param cardDeck the <code>CardSimulator.CardSimulator.CardDeck</code> that will be used
     * @throws IOException
     */
    public GUI(CardDeck cardDeck) throws IOException
    {
        createGUI(cardDeck);
    }


    private void createGUI(CardDeck cardDeck) throws IOException
    {
        // Create the main layout panel
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(DARK_GREEN);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        // Create the card panel
        cardPanel = new CardPanel(cardDeck);

        // Create the info button
        infoButton = createInfoButton();

        // Create the control buttons
        shuffleButton = new JButton("Shuffle");
        shuffleButton.setFocusPainted(false);
        resetButton = new JButton("Reset");

        // Add the info button to the main panel
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 0;
        mainPanel.add(infoButton, constraints);

        // Add the control buttons to the main panel
        constraints.insets.top = 0;
        constraints.insets.bottom = 10;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 2;
        mainPanel.add(shuffleButton, constraints);

        constraints.gridx = 2;
        constraints.weightx = 0.5;
        constraints.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(resetButton, constraints);

        // Add the card panel to the main panel
        constraints.insets.bottom = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.0;
        constraints.gridwidth = 4;
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(cardPanel, constraints);

        // Create the main window
        window = new JFrame("CardSimulator.CardSimulator.CardDeck.Card Simulator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add everything to the main window
        window.add(mainPanel);

        // Set the Icon
        setIcon();

        // Pack the main window
        window.pack();
    }

    private JButton createInfoButton()
    {
        ImageIcon infoIcon;

        String iconPath = '.' + File.separator + "images" + File.separator + "InfoIcon.png";
        infoIcon = new ImageIcon(iconPath);

        JButton button = new JButton(infoIcon);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBackground(DARK_GREEN);

        return button;
    }

    private void setIcon()
    {
        try
        {
            String imagePath = '.' + File.separator + "images" + File.separator + "spades" + File.separator + "king.png";
            File imageFile = new File(imagePath);

            BufferedImage originalImage = ImageIO.read(imageFile);

            window.setIconImage(originalImage);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        CardDeck cardDeck = (CardDeck) e.getSource();

        cardPanel.update(cardDeck);

        window.pack();
    }

    /**
     * Display the CardSimulator.CardSimulator.GUI
     */
    public void start()
    {
        window.setVisible(true);
    }
}
