// Object-Oriented Design
// Chpt 7, pg 127, 7.1

// Deck of cards: Design the data structures for a generic deck of cards.
// Explain how you would subclass the data structures to implement blackjack.

package blackJack;

import java.util.ArrayList;

class Hand {
    private ArrayList<BlackjackCard> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(BlackjackCard card) {
        cards.add(card);
    }

    // This method calculates the total value of the hand
    public int calculateValue() {
        int value = 0;
        int aceCount = 0;

        for (BlackjackCard card : cards) {
            int cardValue = card.getValue();
            value += cardValue;

            // Count the number of Aces in the hand
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }
        }

        // Adjust for the Aces value
        while (value > 21 && aceCount > 0) {
            value -= 10; // Convert Ace from 11 to 1
            aceCount--;
        }

        return value;
    }

    // This method checks if the hand value exceeds 21
    public boolean isBusted() {
        return calculateValue() > 21;
    }

    // This method checks for a Blackjack, which is a hand value of 21 with just two cards
    public boolean hasBlackjack() {
        return cards.size() == 2 && calculateValue() == 21;
    }

    // This method returns the current value of the hand as a string
    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (BlackjackCard card : cards) {
            int cardValue = card.getValue();
            value += cardValue;

            // Count the number of Aces in the hand
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }
        }

        // Adjust for the Aces value
        while (value > 21 && aceCount > 0) {
            value -= 10; // Convert Ace from 11 to 1
            aceCount--;
        }

        return value;
    }

    // This method clears the hand to start a new game
    public void clear() {
        cards.clear();
    }
}

class Player {
    private Hand hand;
    private int chips; // Tracks the player's chip count
    private int bet; // The current bet amount

    public Player() {
        this.hand = new Hand();
        this.chips = 0; // Or some initial value
    }

    // Place a bet for the current hand
    public void placeBet(int amount) {
        // Ensure the player has enough chips to place the bet
        if (amount > chips) {
            System.out.println("You cannot bet more chips than you have!");
            return;
        }
        bet = amount;
        chips -= amount; // Deduct the bet amount from the player's chips
    }

    // The player makes a decision to hit or stand
    public String makeDecision(String decision) {
        return decision.toLowerCase();
    }

    // Check if the player's hand has busted
    public boolean isBusted() {
        return hand.isBusted();
    }

    // Getter for the player's hand
    public Hand getHand() {
        return hand;
    }

    // Getter and setter for the chips
    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    // Getter and setter for the bet
    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}

