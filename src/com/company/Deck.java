package com.company;

import java.util.Observable;
import java.util.Random;

public class Deck extends Observable {

    private final int maxCards = 52;
    private int nextCardInDeck = 0;
    private Card[] deck = new Card[maxCards];
    public Deck() {

        createDeck();
    }

    public void createDeck() {
        int amount = 0;
        char[] colors = {'H', 'D', 'S', 'C'};
        int maxCardsInColor = 13;
        for (char cardColor : colors)
            for (int cardValue = 1; cardValue <= maxCardsInColor; cardValue++) {
                deck[amount] = new Card(cardValue, cardColor);
                amount++;
            }
    }

    public void swapCards(int firstCard, int secondCard) {
        Card temporary;
        temporary = deck[firstCard];
        deck[firstCard] = deck[secondCard];
        deck[secondCard] = temporary;
    }

    public void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            swapCards(i, random.nextInt(maxCards));
        }
        setChanged();
        notifyObservers();
    }

    public void shuffleDeck(int timesToShuffle) {
        for(int i=0; i<timesToShuffle; i++) {
            shuffleDeck();
        }
    }

    public Card getNextCard() {
        return deck[nextCardInDeck++];
    }

    public void resetDeck() {
        nextCardInDeck = 0;
    }

    public Card getCard(int cardIndex) {return deck[cardIndex];}
}
