public class FibonacciSequence {
    private static void calculate(int edge) {
        StringBuilder builder = new StringBuilder();//create an object String for print
        int prev = 0;//previous item
        int cur = 1;//current item
        int tmp = 0;//intermediate item
        for (int i = 0; i < edge; i++) {
            builder.append(cur);
            tmp = cur;
            cur += prev;
            prev = tmp;
            if (i<(edge-1)) {
                builder.append(", ");
            }
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] arg) {
        try {
            int number = Integer.valueOf(arg[0]);
            if (number>=0) {
                calculate(number);
            } else {
                System.out.println("You entered a negative number");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Incorrect data");
        }
    }
}
