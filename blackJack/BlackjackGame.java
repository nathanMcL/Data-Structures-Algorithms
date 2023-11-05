// BlackjackHand Class
// A BlackjackHand class would represent the cards that a player or dealer has been dealt.
// This class could extend an ArrayList of BlackjackCard or could contain such an array list as a member.
// It would need to include methods to calculate the total points of the hand,
// handle the logic for aces (which can be 1 or 11),
// and determine if the hand is a bust, blackjack, or needs to be hit.

package blackJack;

public class BlackjackGame {

    public static void main(String[] args) {
        // Create and shuffle the deck
        BlackjackDeck deck = new BlackjackDeck();
        deck.shuffle();

        // Deal two cards to a player and the dealer
        BlackjackCard playerCard1 = deck.dealCard();
        BlackjackCard playerCard2 = deck.dealCard();
        BlackjackCard dealerCard1 = deck.dealCard();
        BlackjackCard dealerCard2 = deck.dealCard();

        // Show the cards dealt
        System.out.println("Player's Cards: ");
        System.out.println("1: " + playerCard1 + " (" + playerCard1.getValue() + ")");
        System.out.println("2: " + playerCard2 + " (" + playerCard2.getValue() + ")");
        System.out.println("Total Value: " + (playerCard1.getValue() + playerCard2.getValue()));

        System.out.println("\nDealer's Cards: ");
        System.out.println("1: " + dealerCard1 + " (" + dealerCard1.getValue() + ")");
        // Dealer's second card is usually hidden
        System.out.println("2: " + dealerCard2 + " (" + dealerCard2.getValue() + ")");
        System.out.println("Total Value: " + (dealerCard1.getValue() + dealerCard2.getValue()));

    }
}
