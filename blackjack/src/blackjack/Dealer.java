package blackjack;

//: object/Dealer.java

/**
 * Extends the class Player, is used to create the dealer's profile
 */
class Dealer extends Player {
    Dealer() {
        super();
        setName("Dealer");
    }

    boolean makeDecision() {
        return getSum() < 17;
    }
}///:~
