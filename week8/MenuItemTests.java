import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MenuItemTests {
    // test instances
    MenuItem itemOne, itemTwo;

    @BeforeEach
    public void setup(){
        itemOne = null; // kill current instance, hand over to garbage collector
        itemTwo = null; // kill current instance, hand over to garbege collector
    }

    @Test
    public void testSetPrice(){
        // check to see if our setter catches the invalid data
        itemOne = new MenuItem("Cupcake", 3.99, 450);   // set up test instance
        double expectedPrice = itemOne.getPrice();      // save expected price
        itemOne.setPrice(-10);                          // try to set bogus value
        double actualPrice = itemOne.getPrice();        // get the price to test if it was modified

        assertEquals( expectedPrice, actualPrice );     // use assertEquals. actualPrice should be the same

        // check to see if the setter allows valid data to pass
        itemOne = new MenuItem("Cupcake", 3.99, 450);   // set up test instance
        expectedPrice = 9.99;                           // try to pass this in
        itemOne.setPrice(expectedPrice);                // call setter
        actualPrice = itemOne.getPrice();               // get the price to test if it was modified

        assertEquals( expectedPrice, actualPrice );     // use assertEquals. actualPrice should be the same

    }

    @Test
    public void testSetCalories(){
        // check to see if our setter catches the invalid data
        itemOne = new MenuItem("Cupcake", 3.99, 450);         // set up test instance
        int expectedCalories = itemOne.getCalories();         // save expected price
        itemOne.setCalories(-10);                             // try to set bogus value
        double actualCalories = itemOne.getCalories();        // get the price to test if it was modified

        assertEquals( expectedCalories, actualCalories );     // use assertEquals. actualPrice should be the same

        // check to see if the setter allows valid data to pass
        itemOne = new MenuItem("Cupcake", 3.99, 450);         // set up test instance
        expectedCalories = 0;                                 // try to pass this in
        itemOne.setCalories(expectedCalories);                // call setter
        actualCalories = itemOne.getCalories();               // get the price to test if it was modified

        assertEquals( expectedCalories, actualCalories );     // use assertEquals. actualPrice should be the same

    }

    @Test
    public void testConstructorValidation(){
        // test constructor for ability to catch invalid input
        itemTwo = new MenuItem("Black Bean Burger", -9.99, 500);    // try to pass invalid data through the constructor
        double expectedPrice    = 0.0;                              // price should be zero
        double actualPrice      = itemTwo.getPrice();               // see what the actual price is

        assertEquals(expectedPrice, actualPrice);

        // test constructor for ability to let in valid data
        itemTwo = new MenuItem("Black Bean Burger", 9.99, 500);     // try to pass valid data through the constructor
        expectedPrice   = 9.99;                                     // price should be 9.99
        actualPrice     = itemTwo.getPrice();                       // see what the actual price is

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testEquals(){
        itemOne = new MenuItem("Hakarl", 11.99, 600);               // define test instance
        itemTwo = new MenuItem("Hakarl", 11.99, 600);               // define identical test instance

        assertTrue(itemOne.equals( itemTwo ));                      // use assertTrue

        itemOne = new MenuItem("Hakarl", 1.99, 600);                // define test instance
        itemTwo = new MenuItem("Hakarl", 11.99, 600);               // define test instance with different price

        assertFalse(itemOne.equals( itemTwo ));                     // use assertFalse

        itemOne = new MenuItem("Hakarl", 11.99, 500);               // define test instance
        itemTwo = new MenuItem("Hakarl", 11.99, 600);               // define test instance with different calories

        assertFalse(itemOne.equals( itemTwo ));                      // use assertFalse

        itemOne = new MenuItem("Hakarl", 11.99, 600);                // define test instance
        itemTwo = new MenuItem("Corn Dog", 11.99, 600);              // define test instance with different name

        assertFalse(itemOne.equals( itemTwo ));                      // use assertFalse
    }
}
