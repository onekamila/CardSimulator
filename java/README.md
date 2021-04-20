# CardSimulator (Java)
CardSimulator is a computer simulation attempting to model shuffling a deck of cards in a realistic fashion.

## Running the Simulator
*Version 3:* In order to run this program, you must compile the program using javac, and then run the program in Java.

```shell
~/> javac CardSimulator.java
~/> java CardSimulator
Original: [♠A, ♠2, ♠3, ♠4, ♠5, ♠6, ♠7, ♠8, ♠9, ♠10, ♠J, ♠Q, ♠K, ♦A, ♦2, ♦3, ♦4, ♦5, ♦6, ♦7, ♦8, ♦9, ♦10, ♦J, ♦Q, ♦K, ♣A, ♣2, ♣3, ♣4, ♣5, ♣6, ♣7, ♣8, ♣9, ♣10, ♣J, ♣Q, ♣K, ♥A, ♥2, ♥3, ♥4, ♥5, ♥6, ♥7, ♥8, ♥9, ♥10, ♥J, ♥Q, ♥K]
Shuffled once: [♦Q, ♦K, ♣A, ♣2, ♣3, ♣4, ♠A, ♣5, ♣6, ♣7, ♠2, ♣8, ♣9, ♣10, ♠3, ♣J, ♣Q, ♣K, ♠4, ♥A, ♥2, ♠5, ♠6, ♥3, ♠7, ♠8, ♠9, ♠10, ♥4, ♠J, ♥5, ♥6, ♥7, ♥8, ♠Q, ♠K, ♥9, ♥10, ♦A, ♦2, ♦3, ♥J, ♦4, ♦5, ♦6, ♦7, ♦8, ♥Q, ♦9, ♥K, ♦10, ♦J]
Shuffled twice: [♠8, ♠9, ♠10, ♥4, ♠J, ♦Q, ♦K, ♣A, ♣2, ♣3, ♥5, ♣4, ♥6, ♥7, ♠A, ♣5, ♣6, ♥8, ♠Q, ♠K, ♣7, ♥9, ♠2, ♥10, ♣8, ♦A, ♣9, ♦2, ♦3, ♥J, ♦4, ♦5, ♦6, ♣10, ♦7, ♦8, ♥Q, ♠3, ♣J, ♦9, ♣Q, ♥K, ♣K, ♠4, ♥A, ♥2, ♦10, ♠5, ♠6, ♦J, ♥3, ♠7]
Re-sorted: [♠A, ♠2, ♠3, ♠4, ♠5, ♠6, ♠7, ♠8, ♠9, ♠10, ♠J, ♠Q, ♠K, ♦A, ♦2, ♦3, ♦4, ♦5, ♦6, ♦7, ♦8, ♦9, ♦10, ♦J, ♦Q, ♦K, ♣A, ♣2, ♣3, ♣4, ♣5, ♣6, ♣7, ♣8, ♣9, ♣10, ♣J, ♣Q, ♣K, ♥A, ♥2, ♥3, ♥4, ♥5, ♥6, ♥7, ♥8, ♥9, ♥10, ♥J, ♥Q, ♥K]
```
If the default encoding sequence for your OS is **not** UTF-8 (i.e. Windows), your output will look like this:
```shell
Original: [SA, S2, S3, S4, S5, S6, S7, S8, S9, S10, SJ, SQ, SK, DA, D2, D3, D4, D5, D6, D7, D8, D9, D10, DJ, DQ, DK, CA, C2, C3, C4, C5, C6, C7, C8, C9, C10, CJ, CQ, CK, HA, H2, H3, H4, H5, H6, H7, H8, H9, H10, HJ, HQ, HK]
Shuffled once: [DQ, DK, CA, C2, C3, C4, SA, C5, C6, C7, S2, C8, C9, C10, S3, CJ, CQ, CK, S4, HA, H2, S5, S6, H3, S7, S8, S9, S10, H4, SJ, H5, H6, H7, H8, SQ, SK, H9, H10, DA, D2, D3, HJ, D4, D5, D6, D7, D8, HQ, D9, HK, D10, DJ]
Shuffled twice: [S8, S9, S10, H4, SJ, DQ, DK, CA, C2, C3, H5, C4, H6, H7, SA, C5, C6, H8, SQ, SK, C7, H9, S2, H10, C8, DA, C9, D2, D3, HJ, D4, D5, D6, C10, D7, D8, HQ, S3, CJ, D9, CQ, HK, CK, S4, HA, H2, D10, S5, S6, DJ, H3, S7]
Re-sorted: [SA, S2, S3, S4, S5, S6, S7, S8, S9, S10, SJ, SQ, SK, DA, D2, D3, D4, D5, D6, D7, D8, D9, D10, DJ, DQ, DK, CA, C2, C3, C4, C5, C6, C7, C8, C9, C10, CJ, CQ, CK, HA, H2, H3, H4, H5, H6, H7, H8, H9, H10, HJ, HQ, HK]
```
I can't figure out how to make this appear correctly for the time being, my apologies. In the meantime, this is the best I can do.


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
I plan to at least do the following to this project:
* Add graphics
* Add a GUI for this project

## Credits
All code written by Garrett Kamila Crayton. \
For any questions, please email me: <garrett.crayton@gmail.com>