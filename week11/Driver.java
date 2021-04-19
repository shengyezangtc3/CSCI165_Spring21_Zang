/**
 * Author: Shengye Zang
 * Date: April 17, 2021
 * Assignment: Week 11 Lab
 */

public class Driver {
    public static void main(String[] args) {
        
        // Task One
        Employee one = new Employee();
        one.setFirstName("Frank");
        one.setLastName("Stein");
        one.setPhoneNumber("1234567890");
        Date date = new Date(3, 21, 1970);
        Date hired = new Date(3, 21, 2021);
        one.setDOB(date);
        one.setId(123);
        one.setDepartment("IT");
        one.setHireDate(hired);
        System.out.println(one);

        Person person = new Person("Frank", "Stein", "1234567890", date);
        Employee two = new Employee(person, hired, 124, "IT");
        System.out.println(two);

        Employee three = new Employee(two);
        System.out.println(three);
        System.out.println("If two and three are equal? " + two.equals(three));

        // Task Three
        Customer cust1 = new Customer("Frank", "Stein", "1234567890", date, hired, "123");
        Account account = new Account(1234, cust1, date, 0.0);
        System.out.println(account);
        Customer cust = new Customer(two, hired, "123");
        Account account2 = new Account(1234, one, cust, hired);
        System.out.println(account2);

    }
}
