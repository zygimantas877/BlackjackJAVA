package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnitTests {

    @Test
    public void testCard() {
        Card testCard = new Card(12, 'H');
        String result = testCard.getCardName();
        assertEquals("Queen of Hearts", result);
    }

    @Test
    public void testDeck() {
        Deck testDeck = new Deck();
        testDeck.createDeck();
        Card card;
        card = testDeck.getNextCard();
        assertNotNull(card);
    }

    @Test
    public void testBlackjackWithAce() {
        HandPlayer hand = new HandPlayer();
        Deck deck = new Deck();
        hand.drawCard(deck.getCard(0));
        hand.drawCard(deck.getCard(9));
        int result = hand.countTotalHandValue();
        assertEquals(21, result);

    }



}
