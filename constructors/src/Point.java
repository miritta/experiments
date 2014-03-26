/**
 * Created by dolgopyatova on 26.03.2014.
 */
class Point {
    protected int x, y;//can be accessed from the subclasses

    //no-arg constructor
    public Point() {
        x = y = 0;
    }

    //constructor with 2 args
    public Point(int a, int b) {
        x = a;
        y = b;
    }
}

class ColorPoint extends Point{
    protected String color;

    //no-arg constructor, this constructor is called first, then Point(), then Point is done, then ColorPoint is done
    public ColorPoint() {
        color = "red";
    }

    public ColorPoint(int a, int b) {
        super(a, b);//call the super 2-args constructor
        color = "red";
    }

    public ColorPoint(int a, int b, String st) {
        super(a, b);
        color = st;
    }
}