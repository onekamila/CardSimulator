"""Representation of a standard 52-deck of French-suited playing cards.
"""

from random import randint
from CardSuit import SUITS
from CardValue import VALUES
from Card import Card


class CardDeck():
    """Representation of a standard 52-deck of playing cards.
    
    Attributes:

    """

    def __init__(self):
        """Initializes the deck of cards."""
        
        self.cards = []
        self.__newDeck__()
    

    def __newDeck__(self):
        suits = SUITS
        values = VALUES

        for suit in suits:
            for value in values:
                self.cards.append(Card(suit, value))
    

    def shuffle(self):
        """Shuffle the deck of cards in a realistic manner.

        This is done by first splitting the deck roughly in half, and then recombining
        the deck.
        """

        splitPoint = randint(20, 32)
        
        topHalf = self.cards[0:splitPoint]
        bottomHalf = self.cards[splitPoint:]

        self.__recombineDeck__(topHalf, bottomHalf)
    

    def __recombineDeck__(self, leftHalf, rightHalf):
        """
        Recombines the two halfs of the deck of cards in a realistic manner.

        This is done by randomly choosing between one of the two given halves of the
        deck and adding the card at the bottom of the chosen half to a "pile" of 
        cards. Then the process repeats by randomly choosing between the two halves 
        again.
        This process repeats until one of the two halves is depleted, at which point the
        other half is added to the top of the pile. This pile is then saved as the 
        freshly shuffled deck.

        Atrributes:
            leftHalf: list
                one of the two halves of the original deck
            rightHalf: list
                the other half of the original deck
        """

        newDeck = []

        while((len(leftHalf) > 0) and (len(rightHalf) > 0)):
            leftCard = (randint(0, 1) == 0)

            if(leftCard):
                newDeck.append(leftHalf.pop())
            else:
                newDeck.append(rightHalf.pop())
        
        if(len(leftHalf) > 0):
            newDeck = leftHalf + newDeck
        else:
            newDeck = rightHalf + newDeck
        
        self.cards = newDeck


    def reset(self):
        """Set the cards in the deck back to their original (unshuffled) order"""
        self.cards = sorted(self.cards)
    

    def __str__(self):
        deckMap = map((lambda card: str(card)), self.cards) 
        deckList = list(deckMap)
        return str(deckList) 
    

    def __iter__(self):
        self.__index = 0
        return self

    def __next__(self):
        try:
            currentCard = self.cards[self.__index]
            self.__index += 1
            return currentCard
        except IndexError:
            raise StopIteration

__author__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__date__ = "2021 April 11"
__credits__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__version__ = "2.0"