public class Bank {
    Account[] array1 = new Account[3];
    
    Date date = new Date(3, 21, 1970);
    Date hired = new Date(3, 21, 2021);
    Date created = new Date(3, 28, 2021);
    Person person = new Person("Frank", "Stein", "1234567890", date);
    Customer one = new Customer("Frank", "Stein", "1234567890", date, hired, "123");
    Employee two = new Employee(person, hired, 124, "IT");
    array1[0] = new Account(1234, two, one, created);

    public static void update(Account[] list) {
        for (Account account: list) {
            if (account.getClass() == )
        }
    }
}
