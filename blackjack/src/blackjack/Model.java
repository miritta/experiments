package blackjack;

import java.util.ArrayList;
import java.util.Random;

//: object/Model.java

/**
 * Class contains the game logic
 */
class Model {
    private ArrayList<Player> players;
    private Deck deck;
    private int playerNumber;
    private int rate;

    /**
     * Constructor takes entered by user the number of rival and name of user and create deck,
     * list of players and rate. List of players contains user, dealer and some bots.
     * The number of bots is defined by the argument.
     */
    Model(int rivalNumber, String userName) {
        deck = new Deck();
        deck.mixDeck();
        players = new ArrayList<Player>();
        players.add(new User(userName));
        for (int i = 0; i < rivalNumber; i++) {
            players.add(new Player(i));
        }
        players.add(new Dealer());
        playerNumber = players.size();
        Random rand = new Random();
        rate = 60 * (rand.nextInt(5) + 1);
    }

    private int getBank() {
        return playerNumber * rate;
    }

    private void dealCards() {
        for (Player player : players) {
            player.addCard(deck.getUpper());
            player.addCard(deck.getUpper());
        }
    }

    /**
     * Returns the points of the user
     */
    public boolean getUserSum() {
        return players.get(0).getSum() < 21;
    }

    /**
     * Adds one card to the user's list of card.
     */
    public void userTurn() {
        players.get(0).addCard(deck.getUpper());
    }

    private void makeTurn() {
        for (int i = 1; i < playerNumber; i++) {
            Player player = players.get(i);
            while (player.makeDecision()) {
                player.addCard(deck.getUpper());
            }
        }
    }

    private int[] checkPoints() {
        int[] sum = new int[playerNumber];
        for (int i = 0; i < playerNumber; i++) {
            sum[i] = players.get(i).getSum();
        }
        return sum;
    }

    private boolean[] defineWinner(int[] sum) {
        boolean[] winlist = new boolean[playerNumber];
        int max = 0;
        int counter = 0;
        for (int aSum : sum) {
            if (aSum <= 21) {
                if (aSum > max) {
                    max = aSum;
                }
            }
        }
        for (int i = 0; i < playerNumber; i++) {
            if (sum[i] == max) {
                winlist[i] = true;
                counter++;
            } else {
                winlist[i] = false;
            }
        }
        if ((counter != 1) & (winlist[playerNumber - 1])) {//if dealer is winner but there are another winners
            winlist[playerNumber - 1] = false;
        }
        return winlist;
    }

    private int[] definePrize(boolean[] winlist) {
        int[] winPrize = new int[playerNumber];
        int count = 0;
        for (int i = 0; i < playerNumber; i++) {//how many winners
            if (winlist[i]) {
                count++;
            }
        }
        int prizeSize = getBank() / count;
        for (int i = 0; i < playerNumber; i++) {
            if (winlist[i]) {
                winPrize[i] = prizeSize;
            } else {
                winPrize[i] = 0;
            }
        }
        return winPrize;
    }

    /**
     * Returns the data needed for output of the game
     */
    public ArrayList<Object> writeData(boolean ifDealerClosed) {
        ArrayList<Object> allData = new ArrayList<Object>();
        allData.add(players);
        allData.add(rate);
        allData.add(getBank());
        allData.add(ifDealerClosed);
        return allData;
    }

    /**
     * Distributes the cards at the begin of the game for 2 cards per player
     */
    public void beginGame() {
        dealCards();
    }

    /**
     * Returns the list of prizes for every player. If the player has lost, the prize equal to 0.
     */
    public int[] endGame() {
        makeTurn();
        return definePrize(defineWinner(checkPoints()));
    }
}///:~
