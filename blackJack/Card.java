// Object-Oriented Design
// Chpt 7, pg 127, 7.1

// Deck of cards: Design the data structures for a generic deck of cards.
// Explain how you would subclass the data structures to implement blackjack.

package blackJack;

import java.util.ArrayList;
import java.util.Collections;

// Definition of the Suit type using an enum
enum Suit { // Error: java: enum Suit is public, should be declared in a file named Suit.java
    HEARTS, DIAMONDS, CLUBS, SPADES // Represents the four suits in a deck of cards
}

// Definition of the Rank type using an enum
enum Rank { // Error: java: enum Rank is public, should be declared in a file named Rank.java
    // Represents all possible ranks in a deck of cards
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}

// Represents a playing card with a suit and a rank
public class Card {
    // Fields are private for encapsulation, ensuring they can't be changed from outside the class
    private final Suit suit;
    private final Rank rank;

    // Constructor to create a card with a specific suit and rank
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getter method for suit
    public Suit getSuit() {
        return suit;
    }

    // Getter method for rank
    public Rank getRank() {
        return rank;
    }

    // String representation of a card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

// Represents a standard deck of cards
class Deck {
    // Holds the cards currently in the deck
    final ArrayList<Card> cards;

    // Constructor initializes the deck with all possible cards
    public Deck() {
        this.cards = new ArrayList<>();
        // Nested loops to create one card for each combination of suit and rank
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Shuffles the cards in the deck to ensure a random order
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Removes and returns the last card in the deck
    public Card dealCard() {
        return cards.remove(cards.size() - 1);
    }

    // Checks if the deck is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getSize() {
        return cards.size();
    }
}

// Represents a specialized card used in the game of Blackjack
class BlackjackCard extends Card {
    public BlackjackCard(Suit suit, Rank rank) {
        super(suit, rank);
    }

    public int getValue() {
        switch (getRank()) {
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            case ACE:
                return 11; // Typically, ACE can be 1 or 11 depending on the game situation, but we'll default to 11 for now.
        }
        throw new IllegalArgumentException("Unknown card rank");
    }
}

class BlackjackDeck extends Deck {
    public BlackjackDeck() {
        super();
        this.cards.clear();  // Clear the cards list initialized by the parent Deck class.
        // Now populate the Deck with BlackjackCard objects
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new BlackjackCard(suit, rank));
            }
        }
    }

    @Override
    public BlackjackCard dealCard() {
        // This assumes all the cards in the "cards" list are instances of BlackjackCard.
        Card card = super.dealCard();
        if (card instanceof BlackjackCard) {
            return (BlackjackCard) card;
        } else {
            // This should not happen if the deck is correctly initialized with BlackjackCard instances.
            throw new IllegalStateException("Card dealt was not a BlackjackCard instance.");
        }
    }
}


