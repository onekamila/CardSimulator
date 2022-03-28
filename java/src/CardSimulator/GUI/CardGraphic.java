package CardSimulator.GUI;

import javax.swing.*;
import java.awt.*;


/**
 * Container class of the image for a given Card
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public class CardGraphic
{
    private ImageIcon image;
    private int x;
    private int y;


    /**
     * Class constructor
     *
     * @param image the image for a specific <code>Card</code>
     */
    public CardGraphic(ImageIcon image)
    {
        this.image = image;
        x = 0;
        y = 0;
    }


    /**
     * Draws the image
     *
     * @param g the image to be drawn
     * @param c the <code>Component</code> to draw on
     */
    public void draw(Graphics g, Component c)
    {
        image.paintIcon(c, g, x, y);
    }

    /**
     * Set the position of the image
     * @param x the x coordinate for the image
     * @param y the y coordinate for the image
     */
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
