"""Simulates shuffling a standard deck of playing cards in a realistic manner.
"""

from CardDeck import CardDeck 


def main():
    deck = CardDeck()
    print(deck)
    print("")

    deck.shuffle()
    print(deck)
    deck.shuffle()
    print(deck)
    print("")

    deck.reset()
    print(deck)

if __name__ == "__main__":
    main()

__author__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__date__ = "2021 April 11"
__credits__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__version__ = "2.0"