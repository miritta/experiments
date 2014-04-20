public class FibonacciSequence {
    private void Fibonacci(int edge) {
        StringBuilder builder = new StringBuilder("1");//create an object String for print
        int prev = 0;//previous item
        int cur = 1;//current item
        int tmp = 0;//intermediate item
        while (cur != edge) {
            tmp = cur;
            cur += prev;
            prev = tmp;
            if (cur < edge) {
                builder.append(", ").append(cur);
            }else break;
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] arg) {
        try {
            if (Integer.valueOf(arg[0]) == 0) {
                System.out.println("O isn't an item of this sequence");
            } else {
                new FibonacciSequence().Fibonacci(Integer.valueOf(arg[0]));
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Incorrect data");
        }
    }
}
