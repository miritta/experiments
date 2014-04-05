import java.util.Random;

public class Velocity {
    public static void main(String[] args) {
        Random rand = new Random(47);
        double a,t,v;
        a = rand.nextDouble() + rand.nextInt(100);//between 0 and 1;argument is the upper bound
        t = rand.nextDouble() + rand.nextInt(100);
        v = a*t;
        System.out.println("a = "+ a);
        System.out.println("t = "+ t);
        System.out.println("v = a*t = "+ v);
    }
}
