/**
 * Author: Shengye Zang 
 * Date: April 1, 2021 
 * Assignment: Week 9 Lab
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderItemTests {
    OrderItem bundle1, bundle2;
    MenuItem item1, item2;

    @BeforeEach
    public void setup(){
        bundle1 = null; 
        bundle2 = null; 
        item1 = null;
        item2 = null;
    }

    @Test
    public void testGetMenuItem() {
        item1 = new MenuItem("Cupcake", 3.99, 450);
        bundle1 = new OrderItem(item1, 2);
        assertTrue(item1.equals(bundle1.getMenuItem()));
        assertFalse(item1 == bundle1.getMenuItem());
    }

}
