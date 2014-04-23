import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vampire {
    List<String> multipliers;
    List<Integer> results;

    Vampire() {
        multipliers = new ArrayList<String>();
        results = new ArrayList<Integer>();
    }

    private List<Integer> intToList(int base, List<Integer> list) {
        String s = Integer.toString(base);
        for (int i = 0; i < s.length(); i++) {
            list.add(Character.getNumericValue(s.charAt(i)));
        }
        return list;
    }

    private boolean compareLists(List<Integer> list1, List<Integer> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }

    private void calculate(int size) {
        List<Integer> multi = new ArrayList<Integer>();
        List<Integer> parts = new ArrayList<Integer>();
        int min = (int) Math.pow(10, size / 2 - 1);
        int max = min * 10;
        for (int num1 = min; num1 < max; num1++) {
            for (int num2 = min; num2 <= num1; num2++) {
                if ((num1 * num2 % 9) != (num1 + num2) % 9) {// If x·y is a vampire number then x·y == x+y (mod 9)
                    continue;
                }
                int product = num1 * num2;
                intToList(num1, parts);
                intToList(num2, parts);
                intToList(product, multi);
                if (compareLists(parts, multi)) {
                    results.add(product);
                    multipliers.add(num1 + "*" + num2);
                }
                parts.clear();
                multi.clear();
            }
        }
    }

    private void printList(List list) {
        for (Object a : list) {
            System.out.println(a);
        }
    }

    private void printResults(List list1, List list2) {
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i) + "=" + list2.get(i));
        }
    }

    private void performAll(int dim) {
        calculate(dim);
        printList(results);
        printResults(multipliers, results);
    }

    public static void main(String[] arg) {
        Vampire vamp = new Vampire();
        if (arg.length != 0) {
            try {
                int dim = Integer.valueOf(arg[0]);
                if ((dim >= 0) & (dim % 2 == 0)) {
                    vamp.performAll(dim);
                } else {
                    System.out.println("You entered a negative or odd value");
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Incorrect data");
            }
        } else {
            vamp.performAll(4);
        }
    }
}
