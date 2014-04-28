package blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//: object/Controller.java

/**
 * Is used to get the user's answers, address them to the Model
 * and then address to View to print current state of the game
 */
public class Controller {
    private String askName() {
        System.out.println("Enter your name");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private int askPlayerNumber() {
        System.out.println("Enter a number of rivals from 0 to 6");
        Scanner in = new Scanner(System.in);
        int numb = 0;
        try {
            numb = in.nextInt();
            if ((numb < 0) || (numb > 6)) {
                numb = askPlayerNumber();
            }
        } catch (InputMismatchException e) {
            numb = askPlayerNumber();
        }
        return numb;
    }

    private int userDecision() {
        System.out.println("Your turn. Enter 1 to get one more card, enter 0 to stop");
        Scanner in = new Scanner(System.in);
        int dec = 0;
        try {
            dec = in.nextInt();
            if ((dec < 0) || (dec > 1)) {
                dec = userDecision();
            }
        } catch (InputMismatchException e) {
            dec = userDecision();
        }
        return dec;
    }

    /*I'm sure that the first object of the data is ArrayList<Player>
    * but don't have good idea about how to explain it to the compiler*/
    private void printView(ArrayList<Object> data) {
        View view = new View();
        try {
            view.printData((ArrayList<Player>) data.get(0), (Integer) data.get(1), (Integer) data.get(2), (Boolean) data.get(3));
        } catch (ClassCastException e) {
            System.out.println("Bad cast");
        }
    }

    /**
     * Asks user for the rival number and name, launch the game,
     * ask user for decision until his points<21 and user doesn't stop, pass the turn on the rest players
     * and prints the results of the game
     */
    public void game() {
        String name = askName();
        int playerNumber = askPlayerNumber();
        Model model = new Model(playerNumber, name);
        model.beginGame();
        printView(model.writeData(true));//true - dealer's second card is closed still
        while ((model.getUserSum()) && (userDecision() != 0)) {
            model.userTurn();
            printView(model.writeData(true));
        }
        int[] results = model.endGame();
        printView(model.writeData(false));//dealer's cards and points are opened already
        View viewResults = new View();
        viewResults.printResults(results);
    }

    public static void main(String[] arg) {
        Controller controller = new Controller();
        controller.game();
    }
}///:~
