import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PointTests {
    Point one, two;

    @BeforeEach
    public void setup(){
        one = null;
        two = null;
    }

    @Test
    public void testDistance() {
        one = new Point();
        one.setXY(1, 0);
        assertEquals(one.distance(), 1.0);
        one.setX(0);
        one.setY(1);
        assertEquals(one.distance(), 1.0);
        one.setY(0);
        two = new Point(3, 4);
        assertEquals(two.distance(one), 5.0);
        assertEquals(two.distance(0, 0), 5.0);
        assertEquals(Point.distance(one, two), 5.0);
        Point3D point = new Point3D();
        point.setX(1);
        point.setY(0);
        assertEquals(point.distance(one), 1.0);
        MovablePoint point2 = new MovablePoint(one, 1.0f, 1.0f);
        assertEquals(point.distance(point2), 1.0);
    }

    @Test
    public void testEquals() {
        one = new Point(0, 0);
        two = new Point(3, 4);
        assertTrue(one.equals(one));
        assertFalse(one.equals(two));
        one.setXY(3, 4);
        assertTrue(one.equals(two));
        Point3D point = new Point3D(3, 4, 5);
        assertFalse(one.equals(point));
        MovablePoint point2 = new MovablePoint(3, 4, 1.0f, 1.0f);
        assertFalse(one.equals(point2));
    }
}
