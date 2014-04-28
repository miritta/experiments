package blackjack;

import java.util.ArrayList;

//: object/Controller.java

/**
 * Class is used to output the current state of the game.
 */
class View {
    private String printCard(int card) {
        switch (card) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            default:
                return card + "";
        }
    }

    private String currentCards(Player player) {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < player.getCards().size(); i++) {
            build.append(printCard(player.getCards().get(i))).append(" ");
        }
        return build.toString();
    }

    private String dealersCards(Player dealer, boolean closed) {
        StringBuilder builder = new StringBuilder();
        if (closed) {//second dealer's card is closed still
            builder.append("Closed").append(" ");
        } else {
            builder.append(printCard(dealer.getCards().get(0))).append(" ");
        }
        for (int i = 1; i < dealer.getCards().size(); i++) {
            builder.append(printCard(dealer.getCards().get(i))).append(" ");
        }
        return builder.toString();
    }

    private String dealerSum(Player dealer, boolean closed) {
        StringBuilder builder = new StringBuilder();
        if (closed) {//second dealer's card is closed still
            builder.append("Closed");
        } else {
            builder.append(dealer.getSum());
        }
        return builder.toString();
    }

    /**
     * Outputs the list of players, their cards and points
     */
    public void printData(ArrayList<Player> players, int rate, int bank, boolean closed) {
        StringBuilder names = new StringBuilder("       ");
        StringBuilder allCards = new StringBuilder("Cards").append("      ");
        StringBuilder points = new StringBuilder("Points").append("     ");
        int arraySize = players.size();
        for (int i = 0; i < arraySize; i++) {
            Player player = players.get(i);
            names.append("    ").append(player.getName());
            if (i != arraySize - 1) {
                allCards.append(currentCards(player)).append("       ");
                points.append(player.getSum()).append("         ");
            } else {
                allCards.append(dealersCards(player, closed));
                points.append(dealerSum(player, closed));
            }
        }
        System.out.println("   " + "Rate: " + rate + "   " + "Bank: " + bank);
        System.out.println(names.toString());
        System.out.println(allCards.toString());
        System.out.println();
        System.out.println(points.toString());
    }

    /**
     * Outputs the results of the game, winners and their prize
     */
    public void printResults(int[] result) {
        StringBuilder res = new StringBuilder("Result").append("     ");
        for (int aResult : result) {
            if (aResult != 0) {
                res.append("Win: ").append(aResult).append("       ");
            } else {
                res.append("Fail").append("       ");
            }
        }
        System.out.println(res.toString());
    }
}///:~
