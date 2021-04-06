# Title: CardSimulator
# Author: Garrett Kamila Crayton
# Date: 2021 April 6
# Version: 1.0
# Description: Simulates shuffling a deck of playing cards in a realistic manner

import random


cardChars = ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
suitChars = ['♠', '♦', '♣', '♥']
spades = []
diamonds = []
clubs = []
hearts = []
suitLists = [spades, diamonds, clubs, hearts]
deck = []


def init():
    global deck

    for i in range(0, 4):
        currentSuit = suitLists[i]
        suitChar = suitChars[i]

        for cardChar in cardChars:
            fullCard = suitChar + cardChar
            currentSuit.append(fullCard)
        
        deck += currentSuit


def recombineDeck(leftHalf, rightHalf):
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

def shuffleDeck(deck):
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
    init()
    main()