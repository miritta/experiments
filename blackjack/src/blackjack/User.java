package blackjack;

//: object/User.java

/**
 * Extends the class Player. User is used for creation profile of user of the game
 */
class User extends Player {
    /**
     * Constructor takes the entered by the user String as an argument
     */
    User(String s) {
        super();
        setName(s);
    }
}///:~
