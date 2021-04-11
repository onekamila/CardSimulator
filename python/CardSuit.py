"""Representation of a playing card's suit.
"""

class CardSuit():
    """Representation of a playing card's suit.

    Attributes:
        name: str
            the name of the suit
        char: str
            the character representation of the suit
        value: int
            the order the suit appears when the deck is unshuffled
    """

    def __init__(self, name: str, char: str, value: str):
        """Initializes the suit with the given values."""
        self.name = name
        self.char = char
        self.value = value
    

    def __str__(self):
        return self.char
    

    def __eq__(self, other):
        return self.value == other.value
    
    def __ne__(self, other):
        return self.value != other.value
    
    def __lt__(self, other):
        return self.value < other.value
    
    def __le__(self, other):
        return self.value <= other.value
    
    def __gt__(self, other):
        return self.value > other.value

    def __ge__(self, other):
        return self.value >= other.value



SPADES = CardSuit("spades", '♠', 1)
DIAMONDS = CardSuit("diamonds", '♦', 2)
CLUBS = CardSuit("clubs", '♣', 3)
HEARTS = CardSuit("hearts", '♥', 4)

SUITS = [SPADES, DIAMONDS, CLUBS, HEARTS]

__author__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__date__ = "2021 April 11"
__credits__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__version__ = "2.0"