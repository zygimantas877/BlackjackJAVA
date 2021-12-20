package com.company;

public class Main {

    public static void main(String[] args) {

        GameBlackjack blackjack = GameBlackjack.getInstance();

        //Singleton test
        //*
        GameBlackjack blackjack2 = GameBlackjack.getInstance();
        GameBlackjack blackjack3 = GameBlackjack.getInstance();
        if (blackjack == blackjack2 && blackjack2 == blackjack3) {
            System.out.println("Three objects point to the same memory location");
        }
        else {
            System.out.println("Three objects DO NOT point to the same memory location");
        }
        //*/

        blackjack.start();
    }
}
