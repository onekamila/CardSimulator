"""Simulates shuffling a standard deck of playing cards in a realistic manner.

Simulates shuffling a standard deck of playing cards in a realistic manner.
"""

import random


cardChars = ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
suitChars = ['♠', '♦', '♣', '♥']
spades = []
diamonds = []
clubs = []
hearts = []
suitLists = [spades, diamonds, clubs, hearts]
deck = []


def __init__():
    global deck

    for i in range(0, 4):
        currentSuit = suitLists[i]
        suitChar = suitChars[i]

        for cardChar in cardChars:
            fullCard = suitChar + cardChar
            currentSuit.append(fullCard)
        
        deck += currentSuit


def recombineDeck(leftHalf: list, rightHalf: list) -> list:
    """
    Recombine the split deck. 
    Randomly chooses between the left or right half, and adds the bottom card of the chosen half to the top of the new "deck". This repeats until one half is depleted, at which point the other half is added to the top of the new deck.
    
    Args:
        leftHalf: str
            one of the two halves of the original deck
        rightHalf: str
            the other half of the original deck

    Returns:
        The recombined deck
    """

    shuffledDeck = []

    while((len(leftHalf) != 0) and (len(rightHalf) != 0)):
        left = random.choice([True, False])

        if(left):
            shuffledDeck.insert(0, leftHalf.pop())
        else:
            shuffledDeck.insert(0, rightHalf.pop())
        
    if(len(leftHalf) != 0):
        shuffledDeck = leftHalf + shuffledDeck
    else:
        shuffledDeck = rightHalf + shuffledDeck
    
    return shuffledDeck

def shuffleDeck(deck: list) -> list:
    """
    Shuffles the given deck of cards in a realistic manner.

    Splits the deck into two halves, each of slightly different sizes, then calls `recombineDeck()`. 

    Args:
        deck: list
            the deck of cards to be shuffled

    Returns:
        The shuffled deck of cards
    """

    middle = random.randint(20, 32)
    topHalf = deck[0:middle]
    bottomHalf = deck[middle:]
    
    shuffledDeck = recombineDeck(topHalf, bottomHalf)

    return shuffledDeck

def main():
    print(deck)
    print("")

    shuffledDeck = shuffleDeck(deck)

    print(shuffledDeck)


if __name__ == "__main__":
    __init__()
    main()

__author__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__date__ = "2021 April 10"
__credits__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__version__ = "1.0"