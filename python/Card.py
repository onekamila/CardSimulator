"""Representation of a standard playing card.
"""

import CardSuit
import CardValue

class Card():
    """Representation of a standard playing card.

    Attributes:
        suit: CardSuit
        value: CardValue
    """

    def __init__(self, suit: CardSuit, value: CardValue):
        """Initialize the playing card with the given values."""
        self.suit = suit
        self.value = value
    

    def __str__(self):
        return (str(self.suit) + str(self.value))

    
    def __eq__(self, other):
        return ((self.suit == other.suit) and (self.value == other.value))
    
    def __ne__(self, other):
        return ((self.suit != other.suit) or (self.value != other.value))
    
    def __lt__(self, other):
        if(self.suit == other.suit):
            return self.value < other.value
        else:
            return self.suit < other.suit
    
    def __le__(self, other):
        if(self.suit == other.suit):
            return self.value <= other.value
        else:
            return self.suit <= other.suit
    
    def __gt__(self, other):
        if(self.suit == other.suit):
            return self.value > other.value
        else:
            return self.suit > other.suit
    
    def __ge__(self, other):
        if(self.suit == other.suit):
            return self.value >= other.value
        else:
            return self.suit >= other.suit

__author__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__date__ = "2021 April 11"
__credits__ = "Garrett Kamila Crayton (garrett.crayton@gmail.com)"
__version__ = "2.0"