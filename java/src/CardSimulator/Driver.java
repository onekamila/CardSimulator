package CardSimulator;


import CardSimulator.CardDeck.CardDeck;
import CardSimulator.GUI.GUI;
import CardSimulator.GUI.Controller;

import java.io.IOException;
import java.net.URISyntaxException;


/**
 * Copyright 2022 Garrett Kamila Crayton
 *
 * Simulates shuffling a deck of cards in a realistic fashion
 *
 * @author Garrett Kamila Crayton
 * @version 1.0.1
 * @since 1.0.0
 */
public class Driver
{
    private static CardDeck cardDeck;
    private static GUI gui;
    private static Controller controller;


    /**
     * Main class
     *
     * @param args  C-style array declaration of parameter 'args'
     * @throws IOException if something goes wrong
     */
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        init();

        controller.start();
    }

    private static void init() throws IOException, URISyntaxException
    {
        cardDeck = new CardDeck();
        gui = new GUI(cardDeck);
        controller = new Controller(cardDeck, gui);
    }
}