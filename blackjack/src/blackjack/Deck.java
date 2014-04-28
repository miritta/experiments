package blackjack;

import java.util.ArrayList;
import java.util.Collections;

//: object/Deck.java
class Deck {
    private ArrayList<Integer> deck;
    private int cardsNumber;

    /**
     * Default constructor. Adds 52 cards to the deck
     */
    Deck() {
        cardsNumber = 51;
        deck = new ArrayList<Integer>();
        for (int i = 0; i <= cardsNumber; i += 13) {
            for (int j = 2; j < 15; j++) {
                deck.add(j);
            }
        }
    }

    /**
     * Method mixes the deck
     */
    void mixDeck() {
        Collections.shuffle(deck);
    }

    /**
     * Method returns current upper card from the deck
     * and turn penultimate card to new last card
     */
    int getUpper() {
        int last = deck.get(cardsNumber);
        deck.remove(cardsNumber);
        cardsNumber--;
        return last;
    }
}///:~
