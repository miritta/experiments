public class Vampire {
    public static void main(String[] arg) {
        int[] multi = new int[4];//for the results of multiply
        int[] parts = new int[4];//for the multiplied digits
        for (int num1 = 10; num1 < 100; num1++) {
            for (int num2 = 10; num2 < 100; num2++) {
                if ((num1 * num2 % 9) != (num1 + num2) % 9) {
                    continue;//go to the next iteration
                }
                int result = num1*num2;
                parts[1] = num1 % 10;
                parts[0] = num1 / 10;
                parts[2] = num2 / 10;
                parts[3] = num2 % 10;
                String s = Integer.toString(result);
                for(int i=0;i<s.length();i++) {
                    multi[i] = Character.getNumericValue(s.charAt(i));
                }
                int counter = 0;
                for (int k = 0; k < 4; k++) {
                    for (int m = 0; m < 4; m++) {
                        if (multi[k] == parts[m]) {
                            counter++;
                            multi[k] = -1;
                            parts[m] = -2;
                            if (counter == 4) {
                                System.out.println(num1 + "*" + num2 + " = " + result);
                            }
                        }
                    }
                }
            }
        }
    }
}
