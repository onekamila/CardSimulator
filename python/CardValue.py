"""Representation of a playing card's value.
"""

class CardValue():
    """Representation of a playing card's value.

    Attributes:
        name: str
            the name of the value (what players refer to cards with this value, i.e. "ace")
        displayValue: str
            the value displayed on the card (i.e. "A" for an ace)
        cardValue: int
            the value of the card (in a standard deck of cards, this value is its position relative to the other cardsof its suit when the deck is unshuffled)
    """

    def __init__(self, name: str, displayValue: str, cardValue: int):
        """Initializes the card with the given values."""
        self.name = name
        self.displayValue = displayValue
        self.cardValue = cardValue


    '''

    Overloaded functions
    
    '''
    # String representation
    def __str__(self):
        return self.displayValue
    
    # Comparison operators
    def __eq__(self, other):
        return self.cardValue == other.cardValue
    
    def __ne__(self, other):
        return self.cardValue != other.cardValue
    
    def __lt__(self, other):
        return self.cardValue < other.cardValue
    
    def __le__(self, other):
        return self.cardValue <= other.cardValue
    
    def __gt__(self, other):
        return self.cardValue > other.cardValue

    def __ge__(self, other):
        return self.cardValue >= other.cardValue


ACE = CardValue("ace", "A", 1)
TWO = CardValue("two", "2", 2)
THREE = CardValue("three", "3", 3)
FOUR = CardValue("four", "4", 4)
FIVE = CardValue("five", "5", 5)
SIX = CardValue("six", "6", 6)
SEVEN = CardValue("seven", "7", 7)
EIGHT = CardValue("eight", "8", 8)
NINE = CardValue("nine", "9", 9)
TEN = CardValue("ten", "10", 10)
JACK = CardValue("jack", "J", 11)
QUEEN = CardValue("queen", "Q", 12)
KING = CardValue("king", "K", 13)

VALUES = [ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING]


__author__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__date__ = "2021 April 11"
__credits__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__version__ = "2.0"