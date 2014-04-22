import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Vampire {
    private List<Integer> vampireCalculate(int size) {
        List<Integer> multi = new ArrayList<Integer>();
        List<Integer> parts = new ArrayList<Integer>();
        List<Integer> results = new ArrayList<Integer>();
        int max = (int) Math.pow(10, size / 2);
        int min = (int) Math.pow(10, size / 2 - 1);
        for (int num1 = min; num1 < max; num1++) {
            for (int num2 = min; num2 <= num1; num2++) {
                if ((num1 * num2 % 9) != (num1 + num2) % 9) {// Pete Hartley's theoretical result: If x·y is a vampire number then x·y == x+y (mod 9)
                    continue;
                }
                int sum = num1 * num2;
                for (int j = 0; j < size / 2; j++) {
                    parts.add((int) ((num1 % Math.pow(10, j + 1)) / Math.pow(10, j)));
                    parts.add((int) ((num2 % Math.pow(10, j + 1)) / Math.pow(10, j)));
                }
                String s = Integer.toString(sum);
                for (int i = 0; i < s.length(); i++) {
                    multi.add(Character.getNumericValue(s.charAt(i)));
                }
                Collections.sort(parts);
                Collections.sort(multi);
                if (parts.equals(multi)) {
                    results.add(sum);
                }
                parts.clear();
                multi.clear();
            }
        }
        return results;
    }

    public static void main(String[] arg) {
        int dim = 4;
        System.out.println(Arrays.toString(new Vampire().vampireCalculate(dim).toArray()));
    }
}
