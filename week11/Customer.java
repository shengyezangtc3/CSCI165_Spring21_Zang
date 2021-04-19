/**
 * Author: Shengye Zang
 * Date: April 17, 2021
 * Assignment: Week 11 Lab
 */

public class Customer extends Person {
    // fields
    private Date dateJoined;
    private String custID;

    // constructors
    public Customer() {}

    public Customer(String firstName, String lastName, String phone, Date DOB, Date dateJoined, String custID) {
        super(firstName, lastName, phone, DOB);
        this.dateJoined = new Date(dateJoined);
        this.custID = custID;
    }

    public Customer(Person person, Date dateJoined, String custID) {
        super(person);
        this.dateJoined = new Date(dateJoined);
        this.custID = custID;
    }

    public Customer(Customer toCopy) {
        this(toCopy, toCopy.getDateJoined(), toCopy.getCustID());
    }

    // getters and setters
    public Date getDateJoined() {
        return new Date(dateJoined);
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = new Date(dateJoined);
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    // other behaviors
    @Override
    public String toString() {
        return super.toString() + "\nDate Joined: " + dateJoined + "\n ID: " + custID;
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        Customer other1 = (Customer) other;
        return dateJoined.equals(other1.getDateJoined()) && custID.equals(other1.getCustID());
    }
    
}
