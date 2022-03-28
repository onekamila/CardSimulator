package CardSimulator.GUI;

import CardSimulator.CardDeck.Suit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Class that handles reading all card images.
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.0
 */
public class ImageReader
{
    /**
     * Returns a list of <code>ImageIcon</code>s for all cards in a given suit
     *
     * @param suit the <code>Suit</code> of the cards to get images of
     * @return list of <code>ImageIcon</code>s
     * @throws IOException if an error occurs while trying to read the image file
     */
    public static ArrayList<ImageIcon> getImages(Suit suit) throws IOException
    {
        ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
        for(int i = 0; i < 13; i++)
        {
            images.add(null);
        }

        // Get the path of the suit's image dir
        String imageDirPath = '.' + File.separator + "images" + File.separator + suit.name().toLowerCase();
        File imageDir = new File(imageDirPath);

        // Get all image files from the dir
        File[] imageFiles = imageDir.listFiles();

        // Loop through each image file
        for(File imageFile: imageFiles)
        {
            // Open the image file
            BufferedImage fullImage = ImageIO.read(imageFile);
            BufferedImage resizedImage = resizeImage(fullImage, 96, 160);

            // Add the image file to the ArrayList of images
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            addImages(images, imageFile, resizedIcon);
        }

        // Return the ArrayList of images
        return images;
    }

    /**
     * Returns the given image resized to the given dimensions
     *
     * @param image the image to be resized
     * @param width the desired width of the new image
     * @param height the desired height of the new image
     * @return a new <code>BufferedImage</code> of the given dimensions
     */
    public static BufferedImage resizeImage(BufferedImage image, int width, int height)
    {
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage outImage = new BufferedImage(width, height, image.getType());
        outImage.getGraphics().drawImage(resizedImage, 0, 0, null);
        return outImage;
    }

    /**
     * Places the <code>Card</code> images in the appropriate order
     *
     * @param images the list of <code>ImageIcons</code> to be populated
     * @param imageFile the <code>File</code> containing the <code>Card</code>'s icon
     * @param image the <code>ImageIcon</code> for the <code>Card</code>
     */
    private static void addImages(ArrayList<ImageIcon> images, File imageFile, ImageIcon image)
    {
        String[] fullName = imageFile.getName().split("\\.");
        String name = fullName[0];
        if(name.equals("ace"))
        {
            images.set(0, image);
        }
        else if(name.equals("two"))
        {
            images.set(1, image);
        }
        else if(name.equals("three"))
        {
            images.set(2, image);
        }
        else if(name.equals("four"))
        {
            images.set(3, image);
        }
        else if(name.equals("five"))
        {
            images.set(4, image);
        }
        else if(name.equals("six"))
        {
            images.set(5, image);
        }
        else if(name.equals("seven"))
        {
            images.set(6, image);
        }
        else if(name.equals("eight"))
        {
            images.set(7, image);
        }
        else if(name.equals("nine"))
        {
            images.set(8, image);
        }
        else if(name.equals("ten"))
        {
            images.set(9, image);
        }
        else if(name.equals("jack"))
        {
            images.set(10, image);
        }
        else if(name.equals("queen"))
        {
            images.set(11, image);
        }
        else if(name.equals("king"))
        {
            images.set(12, image);
        }
        else
        {
            System.out.println("Unknown card \"" + name + "\". Ignoring.");
        }
    }
}
