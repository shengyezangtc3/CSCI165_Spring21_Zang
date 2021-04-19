import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SavingsAccountTests {
    @Test
    public void testConstructors() {
        Date date = new Date(3, 21, 1970);
        Date hired = new Date(3, 21, 2021);
        Date created = new Date(3, 28, 2021);
        Person person = new Person("Frank", "Stein", "1234567890", date);
        Employee one = new Employee(person, hired, 124, "IT");
        Customer two = new Customer("Frank", "Stein", "1234567890", date, hired, "123");
        SavingsAccount account1 = new SavingsAccount(1234, two, created, 1000.0, 0.02);
        SavingsAccount account2 = new SavingsAccount(account1);
        assertTrue(account1.equals(account2));
        assertEquals(account1.getInterest(), 0.02);
        SavingsAccount account3 = new SavingsAccount(1234, one, two, created, 0.02);
        assertEquals(account3.getInterest(), 0.02);
    }

    // equals() has been tested in the test above
    @Test
    public void testAddInterest() {
        Date date = new Date(3, 21, 1970);
        Date hired = new Date(3, 21, 2021);
        Date created = new Date(3, 28, 2021);
        Person person = new Person("Frank", "Stein", "1234567890", date);
        Employee one = new Employee(person, hired, 124, "IT");
        Customer two = new Customer("Frank", "Stein", "1234567890", date, hired, "123");
        SavingsAccount account1 = new SavingsAccount(1234, two, created, 1000.0, 0.02);
        account1.addInterest();
        assertEquals(account1.getBalance(), 1020.0);
        SavingsAccount account2 = new SavingsAccount(1234, one, two, created, 0.02);
        account2.setBalance(100.0);
        account2.addInterest();
        assertEquals(account2.getBalance(), 102.0);
    }
}
