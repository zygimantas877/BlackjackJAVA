package com.company;

import java.util.Observable;
import java.util.Observer;

public class ObserverDeck implements Observer {

    private Deck deckUpdate ;

    @Override
    public void update(Observable observable, Object arg)
    {
        deckUpdate = (Deck) observable;
        System.out.println("Deck shuffled");
    }
}
