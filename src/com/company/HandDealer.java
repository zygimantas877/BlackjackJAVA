package com.company;

public class HandDealer extends HandPlayer {

    private Card[] hand = new Card[22];
    private int amountOfCards = 0;

    @Override
    public void printHand() {
        System.out.println("Dealer has :");
        for (int i=0; i<amountOfCards; i++)
        {
            System.out.println(hand[i].getCardName());
        }
        System.out.println("Total value: " + countTotalHandValue());
        System.out.println();
    }

}
