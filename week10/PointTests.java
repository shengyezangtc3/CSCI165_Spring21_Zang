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
    }

    @Test
    public void testEquals() {
        one = new Point(0, 0);
        two = new Point(3, 4);
        assertTrue(one.equals(one));
        assertFalse(one.equals(two));
        one.setXY(3, 4);
        assertTrue(one.equals(two));
    }
}
