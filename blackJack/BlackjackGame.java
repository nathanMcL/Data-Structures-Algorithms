/*
 BlackjackHand class
 A BlackjackHand class would represent the cards that a player or dealer has been dealt.
 This class could extend an ArrayList of BlackjackCard or could contain such an array list as a member.
 It would need to include methods to calculate the total points of the hand,
 handle the logic for aces (which can be 1 or 11),
 and determine if the hand is a bust, blackjack, or needs to be hit.
*/

package blackJack;

import java.util.Scanner;

public class BlackjackGame {

    private BlackjackDeck deck; // The deck of cards for the game
    private Hand playerHand; // The player's hand
    private Hand dealerHand; // The dealer's hand
    private boolean gameIsRunning; // Flag to control the game loop
    private Scanner scanner; // Scanner to read player input

    // Constructor initializes the game with a shuffled deck and empty hands
    public BlackjackGame() {
        deck = new BlackjackDeck(); // Create a new deck of blackjack cards
        playerHand = new Hand(); // Initialize the player's hand
        dealerHand = new Hand(); // Initialize the dealer's hand
        gameIsRunning = true; // Set the game as active
        scanner = new Scanner(System.in); // Initialize the scanner for user input
    }

    // Deals initial two cards to both player and dealer
    public void dealInitialCards() {
        deck.shuffle(); // Shuffle the deck before dealing
        // Deal two cards to the player
        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        // Deal two cards to the dealer
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
    }

    // Handles the logic for the player's turn where they can hit or stand
    public void playerTurn() {
        System.out.println("Player's turn");

        // Show the player's initial hand
        System.out.println("Your hand: " + playerHand);

        // Player decision loop
        boolean turnEnded = false;
        while (!turnEnded && !playerHand.isBusted()) {
            // Prompt for player decision and handle input
            System.out.println("Your current hand value: " + playerHand.getValue());
            System.out.print("Would you like to 'hit' or 'stand'? (h/s): ");
            String playerChoice = scanner.nextLine().toLowerCase();

            // Player chooses to hit
            if ("h".equals(playerChoice)) {
                BlackjackCard newCard = deck.dealCard();
                playerHand.addCard(newCard);
                System.out.println("You drew: " + newCard);
                System.out.println("Your hand is now: " + playerHand);

                // Check for player bust after hitting
                if (playerHand.isBusted()) {
                    System.out.println("You busted with a hand value of: " + playerHand.getValue());
                    turnEnded = true;
                }
            }
            // Player chooses to stand
            else if ("s".equals(playerChoice)) {
                System.out.println("You have chosen to stand with a hand value of: " + playerHand.getValue());
                turnEnded = true;
            }
            // Player inputs an invalid option
            else {
                System.out.println("Invalid option. Please type 'h' to hit or 's' to stand.");
            }
        }
    }

    // Handles the logic for the dealer's turn where they must hit until they reach 17 or higher
    public void dealerTurn() {
        System.out.println("Dealer's turn");

        // Dealer reveals their hand
        System.out.println("Dealer's hand: " + dealerHand);
        System.out.println("Dealer's hand value: " + dealerHand.getValue());

        // Dealer hits until their hand's value is at least 17
        while (dealerHand.getValue() < 17) {
            BlackjackCard newCard = deck.dealCard();
            dealerHand.addCard(newCard);

            System.out.println("Dealer draws: " + newCard);
            System.out.println("Dealer's hand is now: " + dealerHand);
            System.out.println("Dealer's hand value: " + dealerHand.getValue());
        }

        // Check if the dealer has busted after hitting
        if (dealerHand.isBusted()) {
            System.out.println("Dealer busts with a hand value of: " + dealerHand.getValue());
        } else {
            System.out.println("Dealer stands with a hand value of: " + dealerHand.getValue());
        }
    }

    // Compares the values of the player's and dealer's hands to resolve bets
    public void resolveBets() {
        int playerValue = playerHand.getValue();
        int dealerValue = dealerHand.getValue();
        boolean playerBusted = playerHand.isBusted();
        boolean dealerBusted = dealerHand.isBusted();

        System.out.println("Resolving bets...");

        // Player busts and dealer wins
        if (playerBusted) {
            System.out.println("You busted. Dealer wins.");
        }
        // Dealer busts and player wins
        else if (dealerBusted) {
            System.out.println("Dealer busts, you win!");
        }
        // Neither busts, compare hand values to determine winner
        else {
            if (playerValue > dealerValue) {
                System.out.println("You win with a higher hand!");
            } else if (playerValue < dealerValue) {
                System.out.println("Dealer wins with a higher hand!");
            } else {
                System.out.println("It's a tie!");
            }
        }
        // Potential area to handle bet payouts or collection
    }

    // Asks the player if they want to play another hand and handles their response
    public void askForNewGame() {
        System.out.print("Would you like to play another hand? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();

        // Player decides to play another hand
        if ("y".equals(input)) {
            playerHand.clear();
            dealerHand.clear();
            // Reshuffle the deck if it's running low on cards
            if (deck.getSize() < 15) {
                deck = new BlackjackDeck();
                deck.shuffle();
            }
            System.out.println("Starting a new game!");
        }
        // Player decides not to continue playing
        else if ("n".equals(input)) {
            gameIsRunning = false;
            System.out.println("Thank you for playing!");
        }
        // Player provides invalid input
        else {
            System.out.println("Invalid option. Please type 'y' to continue or 'n' to exit.");
            askForNewGame();
        }
    }

    // Main game loop that runs the sequence of blackjack play
    public void playGame() {
        while (gameIsRunning) {
            dealInitialCards(); // Deals cards to start the game
            playerTurn();       // Runs the player's turn
            dealerTurn();       // Runs the dealer's turn
            resolveBets();      // Resolves the bets based on the turns
            askForNewGame();    // Asks if the player wants to start a new game
        }
    }

    // Entry point of the program to start the blackjack game
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.playGame();
    }
}
