package blackjack;

import java.util.ArrayList;
import java.util.Random;

//: object/Player.java

/**
 * SuperClass for players, is used for bots creation as is
 */
class Player {
    private String name;
    private ArrayList<Integer> cards;
    private int sum = 0;

    protected Player() {
        cards = new ArrayList<Integer>();
    }

    /**
     * Constructor. Argument is the number of rivals entered by the user
     */
    protected Player(int number) {
        cards = new ArrayList<Integer>();
        name = "Player " + (number + 1);
    }

    String getName() {
        return name;
    }

    void setName(String s) {
        name = s;
    }

    ArrayList<Integer> getCards() {
        return cards;
    }

    /**
     * Calculate the number of points of one card
     */
    void calculatePoints(int elem) {
        if ((elem >= 2) & (elem <= 10)) {//cards 2-10
            sum += elem;
        } else if ((elem == 11) | (elem == 12) | (elem == 13)) {//Jack or King or Queen
            sum += 10;
        } else if (sum + 11 > 21) {//if Ace==11 go beyond 21
            sum += 1;
        } else {//if Ace==11 and sum <21
            sum += 11;
        }
    }

    int getSum() {
        return sum;
    }

    /**
     * Add one upper card from the deck to the list of player's cards
     */
    void addCard(int newCard) {
        cards.add(cards.size(), newCard);
        calculatePoints(newCard);
    }

    /**
     * make a decision whether the player should get one more card or not
     */
    boolean makeDecision() {
        Random rand = new Random();
        return sum <= 10 || (sum > 10) & (sum < 17) && rand.nextDouble() > 0.5;
    }
}///:~
