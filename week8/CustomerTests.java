import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTests {
    Customer customer1, customer2;

    @BeforeEach
    public void setup() {
        customer1 = null;
        customer2 = null;
    }

    @Test
    public void testSetEmail() {
        customer1 = new Customer("Tom", "abc@def.com", "1234567890");
        String expectedEmail = customer1.getEmail();
        
        // @ at first
        customer1.setEmail("@adc@dac.com");
        String actualEmail = customer1.getEmail();
        assertEquals(expectedEmail, actualEmail);
        // @ at last
        customer1.setEmail("abc@def@");
        actualEmail = customer1.getEmail();
        assertEquals(expectedEmail, actualEmail);
        // @ after the last dot
        customer1.setEmail("abc@def.co@m");
        actualEmail = customer1.getEmail();
        assertEquals(expectedEmail, actualEmail);
        // prefix longer than 64
        customer1.setEmail("12345678901234567890123456789012345678901234567890123456789012345@abc.com");
        actualEmail = customer1.getEmail();
        assertEquals(expectedEmail, actualEmail);
        // prefix include invalid characters
        customer1.setEmail("a c@def.com");
        actualEmail = customer1.getEmail();
        assertEquals(expectedEmail, actualEmail);
        // dot at first
        customer1.setEmail(".abc@def.com");
        actualEmail = customer1.getEmail();
        assertEquals(expectedEmail, actualEmail);
        // dot at last of prefix
        customer1.setEmail("abc.@def.com");
        actualEmail = customer1.getEmail();
        assertEquals(expectedEmail, actualEmail);
        // two consecutive periods
        customer1.setEmail("a..bc@def.com");
        actualEmail = customer1.getEmail();
        assertEquals(expectedEmail, actualEmail);

        // check to see if the setter allows valid data to pass
        customer1 = new Customer("Tom", "abc@def.com", "1234567890");
        expectedEmail = "abbc@def.com";
        customer1.setEmail(expectedEmail);
        actualEmail = customer1.getEmail();
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void testSetPhone() {
        customer1 = new Customer("Tom", "abc@def.com", "1234567890");
        String expectedPhone = "Not on file";
        // Not 10 digits
        customer1.setPhone("1234");
        String actualPhone = customer1.getPhone();
        assertEquals(expectedPhone, actualPhone);
        // Not numeric input
        customer1 = new Customer("Tom", "abc@def.com", "1234567890");
        customer1.setPhone("abc");
        actualPhone = customer1.getPhone();
        assertEquals(expectedPhone, actualPhone);
    }

    @Test
    public void testConstructorValidation() {
        // Validation for phone
        customer2 = new Customer("Bob", "adc@top.mid", "1234");
        String expectedPhone = "Not on file";
        String actualPhone = customer2.getPhone();
        assertEquals(expectedPhone, actualPhone);

        // Validation for email
        customer2 = new Customer("Bob", "@adc@dac.com", "1234");
        String expectedEmail = null;
        String actualEmail = customer2.getEmail();
        assertEquals(expectedEmail, actualEmail);

        customer2 = new Customer("Bob", "abc@def@", "1234");
        actualEmail = customer2.getEmail();
        assertEquals(expectedEmail, actualEmail);

        customer2 = new Customer("Bob", "abc@def.co@m", "1234");
        actualEmail = customer2.getEmail();
        assertEquals(expectedEmail, actualEmail);

        customer2 = new Customer("Bob", "12345678901234567890123456789012345678901234567890123456789012345@abc.com", "1234");
        actualEmail = customer2.getEmail();
        assertEquals(expectedEmail, actualEmail);

        customer2 = new Customer("Bob", "a c@def.com", "1234");
        actualEmail = customer2.getEmail();
        assertEquals(expectedEmail, actualEmail);

        customer2 = new Customer("Bob", ".abc@def.com", "1234");
        actualEmail = customer2.getEmail();
        assertEquals(expectedEmail, actualEmail);

        customer2 = new Customer("Bob", "abc.@def.com", "1234");
        actualEmail = customer2.getEmail();
        assertEquals(expectedEmail, actualEmail);

        customer2 = new Customer("Bob", "a..bc@def.com", "1234");
        actualEmail = customer2.getEmail();
        assertEquals(expectedEmail, actualEmail);

        // Valid input
        customer2 = new Customer("Bob", "adc@top.mid", "1234");
        expectedEmail = "adc@top.mid";
        actualEmail = customer2.getEmail();
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    public void testEquals() {
        // Test the case when two customers are initialized with same inputs
        customer1 = new Customer("Bob", "adc@top.mid", "1234567890");
        customer2 = new Customer("Bob", "adc@top.mid", "1234567890");
        assertTrue(customer1.equals(customer2));

        // Test the case when two customers are initialized with different inputs
        customer1 = new Customer("Bob", "adc@top.mid", "1234567890");
        customer2 = new Customer("Tom", "adc@top.mid", "1234567890");
        assertFalse(customer1.equals(customer2));

        customer1 = new Customer("Bob", "adc@top.mid", "1234567890");
        customer2 = new Customer("Bob", "adcb@top.mid", "1234567890");
        assertFalse(customer1.equals(customer2));

        customer1 = new Customer("Bob", "adc@top.mid", "1234567890");
        customer2 = new Customer("Bob", "adc@top.mid", "1234567800");
        assertFalse(customer1.equals(customer2));
    }
}
