import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        // I have tested various constructors in my tests.
        // toStrings
        Point one = new Point(1, 2);
        System.out.println(one);
        Point3D two = new Point3D(3, 2, 1);
        System.out.println(two);
        MovablePoint three = new MovablePoint(1, 1, 1.0f, 1.0f);
        System.out.println(three);

        // inherited methods (I have called the inherited setter methods in my tests, so I just print the results of getters)
        System.out.println(two.getX());
        System.out.println(two.getY());
        System.out.println(Arrays.toString(two.getXY()));
        System.out.println(three.getX());
        System.out.println(three.getY());
        System.out.println(Arrays.toString(three.getXY()));

        // distances
        System.out.println(one.distance());
        System.out.println(one.distance(two));
        System.out.println(two.distance(three));
        System.out.println(Point.distance(one, three));

        // Polymorphism
        Point[] points = new Point[9];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 1);
        points[2] = new Point(1, 0);
        points[3] = new Point3D(0, 0, 0);
        points[4] = new Point3D(1, 1, 0);
        points[5] = new Point3D(0, 0, 1);
        points[6] = new MovablePoint(0, 0, 1.0f, 1.0f);
        points[7] = new MovablePoint(0, 1, 1.0f, 0.0f);
        points[8] = new MovablePoint(1, 0, 0.0f, 1.0f);

        for(Point element: points) {
            System.out.println(element);
            System.out.println(element.getZ());
        }

        Object[] objects = new Object[9];
        objects[0] = new Point(0, 0);
        objects[1] = new Point(0, 1);
        objects[2] = new Point(1, 0);
        objects[3] = new Point3D(0, 0, 0);
        objects[4] = new Point3D(1, 1, 0);
        objects[5] = new Point3D(0, 0, 1);
        objects[6] = new MovablePoint(0, 0, 1.0f, 1.0f);
        objects[7] = new MovablePoint(0, 1, 1.0f, 0.0f);
        objects[8] = new MovablePoint(1, 0, 0.0f, 1.0f);

        for(Object element: objects) {
            System.out.println(element);
            System.out.println(element.getZ());
        }

        // Since the method is only defined in a subclass of Point class, the objects of Point class could not access
        // the method, which causes the compiler to complain.
    }
}
