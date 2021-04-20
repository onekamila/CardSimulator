# CardSimulator
CardSimulator is a computer simulation attempting to model shuffling a deck of cards in a realistic manner. 

## Running the Simulator
*version 2.0:* In order to run this program, simply run this code within Python. 
```powershell
> python CardSimulator.py
['♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♠8', '♠9', '♠10', '♠J', '♠Q', '♠K', '♦A', '♦2', '♦3', '♦4', '♦5', '♦6', '♦7', '♦8', '♦9', '♦10', '♦J', '♦Q', '♦K', '♣A', '♣2', '♣3', '♣4', '♣5', '♣6', '♣7', '♣8', '♣9', '♣10', '♣J', '♣Q', '♣K', '♥A', '♥2', '♥3', '♥4', '♥5', '♥6', '♥7', '♥8', '♥9', '♥10', '♥J', '♥Q', '♥K']

['♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♦K', '♣A', '♣2', '♠8', '♠9', '♣3', '♣4', '♣5', '♣6', '♠10', '♣7', '♣8', '♠J', '♣9', '♣10', '♣J', '♣Q', '♣K', '♠Q', '♥A', '♥2', '♠K', '♥3', '♦A', '♥4', '♦2', '♥5', '♦3', '♥6', '♥7', '♦4', '♦5', '♥8', '♦6', '♦7', '♥9', '♦8', '♦9', '♥10', '♥J', '♥Q', '♥K', '♦10', '♦J', '♦Q']
``` 
In order to shuffle the same deck multiple times, run the program as a module. 
```console
> python
Python 3.9.1 (tags/v3.9.1:1e5d33e, Dec  7 2020, 17:08:21) [MSC v.1927 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license" for more information.
> import CardSimulator
> CardSimulator.init()
> originalDeck = CardSimulator.deck
> print(originalDeck)
['♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♠8', '♠9', '♠10', '♠J', '♠Q', '♠K', '♦A', '♦2', '♦3', '♦4', '♦5', '♦6', '♦7', '♦8', '♦9', '♦10', '♦J', '♦Q', '♦K', '♣A', '♣2', '♣3', '♣4', '♣5', '♣6', '♣7', '♣8', '♣9', '♣10', '♣J', '♣Q', '♣K', '♥A', '♥2', '♥3', '♥4', '♥5', '♥6', '♥7', '♥8', '♥9', '♥10', '♥J', '♥Q', '♥K']
> shuffledDeck = CardSimulator.shuffleDeck(shuffledDeck)
> print(shuffledDeck)
['♠A', '♠2', '♠3', '♠4', '♠5', '♠6', '♠7', '♦K', '♣A', '♣2', '♠8', '♠9', '♣3', '♣4', '♣5', '♣6', '♠10', '♣7', '♣8', '♠J', '♣9', '♣10', '♣J', '♣Q', '♣K', '♠Q', '♥A', '♥2', '♠K', '♥3', '♦A', '♥4', '♦2', '♥5', '♦3', '♥6', '♥7', '♦4', '♦5', '♥8', '♦6', '♦7', '♥9', '♦8', '♦9', '♥10', '♥J', '♥Q', '♥K', '♦10', '♦J', '♦Q']
> shuffledDeck = CardSimulator.shuffleDeck(shuffledDeck)
> print(shuffledDeck)
['♠A', '♠2', '♥3', '♠3', '♦A', '♠4', '♥4', '♦2', '♥5', '♦3', '♥6', '♠5', '♠6', '♠7', '♥7', '♦K', '♣A', '♣2', '♠8', '♦4', '♠9', '♦5', '♣3', '♣4', '♣5', '♣6', '♥8', '♦6', '♠10', '♦7', '♣7', '♣8', '♠J', '♥9', '♦8', '♦9', '♣9', '♣10', '♥10', '♣J', '♥J', '♥Q', '♣Q', '♣K', '♥K', '♠Q', '♦10', '♥A', '♥2', '♦J', '♦Q', '♠K']
```

## Overview
This projects aims to model shuffling a standard deck of playing cards in a realistic fashion. \
What do I mean by "realistic"? I mean the same way that it is done in real-life, and not cheating using a simple randomizer to jumble the order.

### Process
First, the model begins by taking a given deck of playing cards, and splitting that deck roughly in half (the split is not exactly half, and this is intentional). \
Then, the randomly chooses which half to pick from, the first (or "top") half, or the second ("bottom") half. It proceeds to take the last card in the chosen half, and add it to the beginning of the a new "deck". This repeats until one half is exhausted, at which point the other half is added to the front of the new deck.

### Reasoning
Now you're probably wondering to yourself: *why go through all this trouble, rather than simply randomizing the deck?* This is a valid question, and makes total sense. \
The reason I took the approach outlined above is because it closely resembles how a deck of cards is shuffled in real-life. The shuffler first splits the deck in half, then arches both halves, slowly releasing cards one-by-one back into the pile and then recombining all the cards into one deck of cards. However, the cards are released asynchonously. In other words, a card from the one half is not immediately followed by a card from the other. Rather, a number of cards can be released from one half before a card from the other deck is released. This further randomizes the cards, as the order cannot be predicted.

### Next Steps
I plan to at least do the following to this project:
* Translate to Java
* Add graphics
* (*Maybe*) Add a GUI for this

## Credits
All code written by Garrett Kamila Crayton. \
For any questions, please email me: <garrett.crayton@gmail.com>
