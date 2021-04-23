/**
 * Simulates shuffling a deck of cards in a realistic fashion.
 *
 * @author Garrett Kamila Crayton
 * @version 1.0
 */
public class CardSimulator
{
    /**
     * Main class
     * @param args  C-style array declaration of parameter 'args'
     */
    public static void main(String[] args)
    {
        CardDeck testDeck = new CardDeck();

        System.out.println("Original: " + testDeck);
        testDeck.shuffle();
        System.out.println("Shuffled once: " + testDeck);
        testDeck.shuffle();
        System.out.println("Shuffled twice: " + testDeck);
        testDeck.reset();
        System.out.println("Re-sorted: " + testDeck);
    }
}