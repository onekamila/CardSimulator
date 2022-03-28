# CardSimulator
CardSimulator is a computer simulation attempting to model shuffling a deck of cards in a realistic fashion.

## Running the Simulator
*Version 1.0.0:* In order to run this program, you must compile the program using javac, and then run the program in Java.
```shell
~/> javac CardSimulator.java
~/> java CardSimulator
```


## Overview
This projects aims to model shuffling a standard deck of playing cards in a realistic fashion. \
What do I mean by "realistic"? I mean the same way that it is done in real-life, and not cheating using a simple randomizer to jumble the order.

### Process
First, the model begins by taking a given deck of playing cards, and splitting that deck roughly in half (the split is not exactly half, and this is intentional). \
Then, the randomly chooses which half to pick from, the first (or "top") half, or the second ("bottom") half. It proceeds to take the last card in the chosen half, and add it to the beginning of the a new "deck". This repeats until one half is exhausted, at which point the other half is added to the front of the new deck.

### Reasoning
Now you're probably wondering to yourself: *why go through all this trouble, rather than simply randomizing the deck?* \
This is a valid question, and makes total sense. \
The reason I took the approach outlined above is because it closely resembles how a deck of cards is shuffled in real-life. The shuffler first splits the deck in half, then arches both halves, slowly releasing cards one-by-one back into the pile and then recombining all the cards into one deck of cards. However, the cards are released asynchonously. In other words, a card from the one half is not immediately followed by a card from the other. Rather, a number of cards can be released from one half before a card from the other deck is released. This further randomizes the cards, as the order cannot be predicted.



### Next Steps
In terms of UI/UX features, I plan to possibly add the following to this project:
* Allow for the user to use their own card graphics
* Add shuffling animations
* Make buttons look a litter nicer

## Credits
All code written by Garrett Kamila Crayton. \
All images used in this project courtesy of [Cburnett][2].\
For any questions, please email me: [garrett.crayton@gmail.com][1]



[1]: garrett.crayton@gmail.com
[2]: https://en.wikipedia.org/wiki/User:Cburnett