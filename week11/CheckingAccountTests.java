import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CheckingAccountTests {
    @Test
    public void testConstructors() {
        Date date = new Date(3, 21, 1970);
        Date hired = new Date(3, 21, 2021);
        Date created = new Date(3, 28, 2021);
        Person person = new Person("Frank", "Stein", "1234567890", date);
        Employee one = new Employee(person, hired, 124, "IT");
        Customer two = new Customer("Frank", "Stein", "1234567890", date, hired, "123");
        CheckingAccount account1 = new CheckingAccount(1234, two, created, 1000.0, 1000.0);
        CheckingAccount account2 = new CheckingAccount(account1);
        assertTrue(account1.equals(account2));
        assertEquals(account1.getLimit(), 1000.0);
        CheckingAccount account3 = new CheckingAccount(1234, one, two, created, 500.0);
        assertEquals(account3.getLimit(), 500.0);
    }

    @Test
    public void testIsInOverDraft() {
        Date date = new Date(3, 21, 1970);
        Date hired = new Date(3, 21, 2021);
        Date created = new Date(3, 28, 2021);
        Person person = new Person("Frank", "Stein", "1234567890", date);
        Employee one = new Employee(person, hired, 124, "IT");
        Customer two = new Customer("Frank", "Stein", "1234567890", date, hired, "123");
        CheckingAccount account1 = new CheckingAccount(1234, two, created, 1000.0, 1000.0);
        CheckingAccount account2 = new CheckingAccount(1234, one, two, created, 500.0);
        account2.setBalance(-200.0);
        assertFalse(account1.isInOverDraft());
        assertTrue(account2.isInOverDraft());
    }
}
