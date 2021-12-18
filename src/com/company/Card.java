package com.company;

public class Card {

    private int value;
    private char color;

    public Card(int incomingValue, char incomingColor) {
        value = incomingValue;
        color = incomingColor;
    }

    public int getValue() {
        return value;
    }

    public String getColorName() {
        return switch (color) {
            case 'H' -> "Hearts";
            case 'D' -> "Diamonds";
            case 'S' -> "Spades";
            case 'C' -> "Clubs";
            default -> "Unassigned card color";
        };
    }

    public String getValueName() {
        return switch (value) {
            case 1 -> "Ace";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "10";
            case 11 -> "Jack";
            case 12 -> "Queen";
            case 13 -> "King";
            default -> "Unassigned card value";
        };
    }

    public String getCardName() {
        return getValueName() + " of " + getColorName();
    }
}
