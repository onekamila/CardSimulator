package CardSimulator.GUI;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * The "About" panel that displays when the "Info" button is pressed.
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.1
 * @since 1.0.1
 */
public class InfoPanel extends JPanel
{
    /*
     * Design:
     *
     *
     *
     * (King of Spades on side)
     * Title: Card Simulator
     * Author: Garrett Kamila Crayton (*link to Personal Site*)
     * Created: 2021 July 20
     * Version: 1.0.0 (*link to Git*)
     * License: MIT License
     * Copyright © 2021 Garrett Kamila Crayton (*link to Personal Site*)
     * Images © 2007 Dr. Colin M.L. Burnett (*link to Dr. Burnett wiki page*)
     */
    private static final String PERSONAL_SITE_URL = "https://www.gkcrayton.com/";
    private static final String PROJECT_VERSION = "1.0.1";
    private static final String PROJECT_GITHUB_URL = "https://github.com/onekamila/CardSimulator";
    private static final String BURNETT_SITE_URL = "https://en.wikipedia.org/wiki/User:Cburnett";

    protected JLabel iconLabel;

    protected JLabel titleHeader;
    protected JLabel authorHeader;
    protected JLabel dateHeader;
    protected JLabel versionHeader;
    protected JLabel licenseHeader;
    protected JLabel copyrightHeader;
    protected JLabel imagesHeader;

    protected JLabel titleLabel;
    protected JLabel dateLabel;
    protected JLabel licenseLabel;
    protected JLabel copyrightLabel;
    protected JLabel imagesLabel;

    protected JHyperLink authorLink;
    protected JHyperLink versionLink;
    protected JHyperLink imagesLink;

    protected JPanel imagesSubPanel;

    protected JPanel titlePanel;
    protected JPanel authorPanel;
    protected JPanel datePanel;
    protected JPanel versionPanel;
    protected JPanel licensePanel;
    protected JPanel copyrightPanel;
    protected JPanel imagesPanel;


    /**
     * Class constructor
     */
    public InfoPanel()
    {
        super(new GridBagLayout());
        buildPanel();
    }

    private void buildPanel()
    {
        getIcon();
        createHeaders();
        createLabels();
        createLinks();
        createPanels();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 0, 5, 5);

        // InfoIcon
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.weightx = 0.5;
        constraints.weighty = 0.0;
        constraints.gridwidth = 1;
        constraints.gridheight = 7;
        add(iconLabel, constraints);

        ////Headers
        constraints.gridx = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.LINE_END;

        // Title
        constraints.gridy = 0;
        add(titleHeader, constraints);

        // Author
        constraints.gridy = 1;
        add(authorHeader, constraints);

        // Date
        constraints.gridy = 2;
        add(dateHeader, constraints);

        // Version
        constraints.gridy = 3;
        add(versionHeader, constraints);

        // License
        constraints.gridy = 4;
        add(licenseHeader, constraints);

        // Copyright
        constraints.gridy = 5;
        add(copyrightHeader, constraints);

        // Images
        constraints.gridy = 6;
        add(imagesHeader, constraints);


        //// Labels
        constraints.gridx = 2;
        constraints.gridwidth = 2;
        constraints.weightx = 0.0;
        constraints.anchor = GridBagConstraints.LINE_START;

        // Title
        constraints.gridy = 0;
        add(titleLabel, constraints);

        // Author
        constraints.gridy = 1;
        add(authorLink, constraints);

        // Date
        constraints.gridy = 2;
        add(dateLabel, constraints);

        // Version
        constraints.gridy = 3;
        add(versionLink, constraints);

        // License
        constraints.gridy = 4;
        add(licenseLabel, constraints);

        // Copyright
        constraints.gridy = 5;
        add(copyrightLabel, constraints);

        // Images
        constraints.insets.right = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        add(imagesLabel, constraints);


        // Images Link
        constraints.insets.left = 0;
        constraints.gridx = 3;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        add(imagesLink, constraints);
    }

    private void getIcon()
    {
        iconLabel = new JLabel();

        try
        {
            String imagePath = ImageReader.imagePath + File.separator + "spades" + File.separator + "king.png";
            File imageFile = new File(imagePath);

            BufferedImage originalImage = ImageIO.read(imageFile);
            BufferedImage resizedImage = ImageReader.resizeImage(originalImage, 100, 150);

            ImageIcon cardIcon = new ImageIcon(resizedImage);

            iconLabel.setIcon(cardIcon);
        }
        catch(IOException e)
        {
            String iconPath = ImageReader.imagePath + File.separator + "InfoIcon-Large.png";
            ImageIcon icon = new ImageIcon(iconPath);
            iconLabel.setIcon(icon);
        }
    }

    private void createHeaders()
    {
        titleHeader = new JLabel("Title:");
        authorHeader = new JLabel("Author:");
        dateHeader = new JLabel("Created:");
        versionHeader = new JLabel("Version:");
        licenseHeader = new JLabel("License:");
        copyrightHeader = new JLabel("Copyright:");
        imagesHeader = new JLabel("Images:");
    }

    private void createLabels()
    {
        titleLabel = new JLabel("Card Simulator");
        dateLabel = new JLabel("2022 April 19");
        licenseLabel = new JLabel("MIT License");
        copyrightLabel = new JLabel("\u00a9 April 2022 Garrett Kamila Crayton");
        imagesLabel = new JLabel("\u00a9 March 2007 ");
    }

    private void createLinks()
    {
        authorLink = new JHyperLink("Garrett Kamila Crayton", PERSONAL_SITE_URL);
        versionLink = new JHyperLink(PROJECT_VERSION, PROJECT_GITHUB_URL);
        imagesLink = new JHyperLink("Dr. Colin M.L. Burnett", BURNETT_SITE_URL);
    }

    private void createPanels()
    {
        imagesSubPanel = new JPanel(new GridLayout(1, 2, 5, 5));

        titlePanel = new JPanel(new GridLayout(1, 2, 5, 5));
        authorPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        datePanel = new JPanel(new GridLayout(1, 2, 5, 5));
        versionPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        licensePanel = new JPanel(new GridLayout(1, 2, 5, 5));
        copyrightPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        imagesPanel = new JPanel(new GridLayout(1, 0, 5, 5));
    }
}