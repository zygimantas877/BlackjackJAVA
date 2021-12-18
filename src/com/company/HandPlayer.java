package com.company;

public class HandPlayer extends HandAbstract {

    private Card[] hand = new Card[22];
    private int amountOfCards = 0;

    public void drawCard(Card card) {
        hand[amountOfCards] = card;
        amountOfCards++;
    }

    public void resetHand() {
        amountOfCards = 0;
    }

    public int countTotalHandValue() {
        int totalHandValue = 0;
        int cardValue;
        boolean isAceInHand = false;
        for (int i=0; i<amountOfCards; i++) {
            cardValue = hand[i].getValue();
            if (cardValue > 10) cardValue = 10;
            if (cardValue == 1) isAceInHand = true;
            totalHandValue += cardValue;
        }

        if(isAceInHand && 21 - totalHandValue >= 10) totalHandValue+=10;

        return totalHandValue;
    }

    public boolean hasBlackjack() {
        return countTotalHandValue() == 21;
    }

    public void printHand() {
        System.out.println("Player has :");
        for (int i=0; i<amountOfCards; i++)
        {
            System.out.println(hand[i].getCardName());
        }
        System.out.println("Total value: " + countTotalHandValue());
        System.out.println();
    }

}
