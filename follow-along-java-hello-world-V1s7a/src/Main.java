import edu.princeton.cs.algs4.StdOut;

public class Main {
    public static void main(String[] args){
        //HelloWorld.main(null);
        //StdOut.println(MathLib.square(100));
        //StdOut.println(MathLib.add(100, 100));
        Point point = new Point(); //new pointer malloc
        Point point2 = new Point(9999);
        Point point3 = new Point(4444,55555);
        StdOut.printf("point.x =%d, point.y = %d\n", point.getX(), point.getY());
        StdOut.printf("point.x = %d, point.y = %d\n", point2.getX(), point2.getY());
        StdOut.printf("point.x = %d, point.y = %d\n", point3.getX(), point3.getY());



    }
}
