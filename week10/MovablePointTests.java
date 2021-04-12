import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovablePointTests {
    MovablePoint one, two;

    @BeforeEach
    public void setup(){
        one = null;
        two = null;
    }

    @Test
    public void testEquals() {
        one = new MovablePoint();
        one.setXY(1, 1);
        one.setxSpeed(1.0f);
        one.setySpeed(1.0f);
        assertTrue(one.equals(one));
        Point point = new Point(1, 1);
        two = new MovablePoint(point, 1.0f, 1.0f);
        assertTrue(one.equals(two));
    }
}
