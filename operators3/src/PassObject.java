//: operators/PassObject.java
// Passing objects to methods may not be
// what you’re used to.
class Fletter {
    float c;
}
public class PassObject {
    static void f(Fletter y) {
        y.c = 1f;
    }
    public static void main(String[] args) {
        Fletter x = new Fletter();
        x.c = 2f;
        System.out.println("1: x.c: " + x.c);
        f(x);
        System.out.println("2: x.c: " + x.c);
    }
} /* Output:
1: x.c: a
2: x.c: z
*///:~
