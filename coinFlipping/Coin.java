import java.util.Random;

/**
 * Created by miri_terra on 10.04.14.
 */
public class Coin {

    private final Random random = new Random();

    private boolean flip() {
        return random.nextDouble() <= 0.5;
    }

    private void performThrows(int n) {
        int headNumber = 0;
        int tailNumber = 0;
        for (int i = 0; i < n; i++) {
            if (flip()) {
                ++headNumber;
                System.out.println("Орел");
            } else {
                ++tailNumber;
                System.out.println("Решка");
            }
        }
        System.out.println(headNumber);
        System.out.println(tailNumber);
    }

    public static void main(String[] params) {
        try {
            new Coin().performThrows(Integer.valueOf(params[0]));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Incorrect data");
        }
    }
}
