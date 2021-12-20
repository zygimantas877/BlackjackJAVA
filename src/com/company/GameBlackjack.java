package com.company;

import java.util.Scanner;

public class GameBlackjack {

    private static GameBlackjack instance = null;
    private GameBlackjack () {

    }
    public static GameBlackjack getInstance() {
        if (instance == null)
            instance = new GameBlackjack();
        return instance;
    }


    Deck gameDeck = new Deck();
    HandPlayer playerHand = new HandPlayer();
    HandPlayer dealerHand = new HandDealer();
    private Scanner sc = new Scanner(System.in);
    private boolean replay = false;

    public void start() {
        ObserverDeck observer = new ObserverDeck();
        gameDeck.addObserver(observer);
        do {
            resetGame();
            dealCards();
            if (!isBlackjack()) {
                chooseMove();
                dealerTurn();
                sumUpGame();
            }
            chooseReplay();
        } while (replay);
    }

    private void dealCards() {
        dealerHand.drawCard(gameDeck.getNextCard());
        dealerHand.drawCard(gameDeck.getNextCard());
        playerHand.drawCard(gameDeck.getNextCard());
        playerHand.drawCard(gameDeck.getNextCard());
    }

    public boolean isBlackjack() {
        if(playerHand.hasBlackjack() && !dealerHand.hasBlackjack()) {
            System.out.println("Player wins with a blackjack");
            return true;
        }
        if(!playerHand.hasBlackjack() && dealerHand.hasBlackjack()) {
            System.out.println("Dealer wins with a blackjack");
            return true;
        }
        if(playerHand.hasBlackjack() && dealerHand.hasBlackjack()) {
            System.out.println("Player pushes - player and dealer both have a blackjack");
            return true;
        }
        return false;
    }

    public void chooseMove() {
        char choice;
        do {
            System.out.println("You have: ");
            playerHand.printHand();
            System.out.println("Hit or Stand? (H/S)");

            choice = sc.next().toLowerCase().charAt(0);

            if(choice == 's') {
                System.out.println("You stand");
                return;
            }
            else if(choice == 'h') {
                System.out.println("You draw a card");
                playerHand.drawCard(gameDeck.getNextCard());
                if(playerHand.countTotalHandValue() >= 21) return;
            }
        } while(true);
    }

    public void dealerTurn() {
        while(dealerHand.countTotalHandValue() < 17)
        {
            dealerHand.drawCard(gameDeck.getNextCard());
        }
    }

    public void sumUpGame() {
        int ptv = playerHand.countTotalHandValue();
        int dtv = dealerHand.countTotalHandValue();

        boolean playerExceeded = ptv > 21;
        boolean dealerExceeded = dtv > 21;

        System.out.println("You have: ");
        playerHand.printHand();

        if(playerExceeded) {
            System.out.println("Player loses - hand value over 21. ");
            return;
        }

        if(dtv == ptv) {
            System.out.println("Player pushes - player and dealer have same total value");
        }
        else if(ptv > dtv || dealerExceeded) {
            System.out.println("Player wins - player has a hand value of "
                    + ptv + " while dealer has a hand value of " + dtv);
        }
        else if(ptv < dtv) {
            System.out.println("Player loses - player has a hand value of "
                    + ptv + " while dealer has a hand value of " + dtv);
        }

    }

    public void chooseReplay() {
        char choice;

        do {
            System.out.println("Play again? (Y/N)");
            choice = sc.next().toLowerCase().charAt(0);

            if(choice == 'y') {
                replay = true;
            }
            else if(choice == 'n') {
                System.out.println("Thank you for playing");
                replay = false;
            }
        } while(choice != 'y' && choice != 'n');
    }

    public void resetGame() {
        playerHand.resetHand();
        dealerHand.resetHand();
        gameDeck.shuffleDeck();
        gameDeck.shuffleDeck(4);
        gameDeck.resetDeck();
    }
}
