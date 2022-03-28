package CardSimulator.GUI;


import javax.swing.*;
import java.awt.*;


/**
 * Represents a hyperlink. When clicked-on, it will open a specific page in the user's browser.
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public class JHyperLink extends JLabel
{
    protected String url;


    /**
     * Class constructor
     *
     * @param text the text that is displayed by the hyperlink
     * @param url the URL the link directs to
     */
    public JHyperLink(String text, String url)
    {
        super("<HTML><U>" + text + "</U></HTML>");
        this.url = url;

        setForeground(Color.BLUE.darker());

        setToolTipText(url);

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }


}
