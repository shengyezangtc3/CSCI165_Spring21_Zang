import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Point3DTests {
    Point3D one, two;

    @BeforeEach
    public void setup(){
        one = null;
        two = null;
    }

    @Test
    public void testEquals() {
        one = new Point3D();
        one.setXY(1, 0);
        one.setZ(0);
        assertTrue(one.equals(one));
        two = new Point3D(one);
        assertTrue(one.equals(two));
        Point origin = new Point(0, 0);
        two.setXYZ(origin, 1);
        int[] expect = {0, 0, 1};
        assertTrue(Arrays.equals(expect, two.getXYZ()));
        assertFalse(one.equals(two));
        assertFalse(two.equals(origin));
        MovablePoint point = new MovablePoint(origin, 1.0f, 1.0f);
        assertFalse(two.equals(point));
    }
}
