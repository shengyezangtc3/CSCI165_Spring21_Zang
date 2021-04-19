/**
 * Author: Shengye Zang
 * Date: April 17, 2021
 * Assignment: Week 11 Lab
 */

public class SavingsAccount extends Account {
    private double interest; // I use this variable as the interest and not in percentage. For example, it is 0.05 instead of 5%.

    // constructors
    public SavingsAccount(int accountNumber, Customer owner, Date created, double balance, double interest) {
        super(accountNumber, owner, created, balance);
        this.interest = interest;
    }

    public SavingsAccount(int accountNumber, Employee manager, Customer owner, Date created, double interest) {
        super(accountNumber, manager, owner, created);
        this.interest = interest;
    }

    public SavingsAccount(SavingsAccount toCopy) {
        this(toCopy.getAccountNumber(), toCopy.getCustomer(), toCopy.getDateCreated(), toCopy.getBalance(),toCopy.interest);
    }

    // methods
    public double getInterest() {
        return interest;
    }

    @Override
    public void addInterest() {
        super.setBalance(super.getBalance() * (1 + interest));
    }

    @Override
    public String toString() {
        return super.toString() + "\nInterest: " + interest;
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        SavingsAccount account = (SavingsAccount) other;
        return interest == account.interest;
    }
}
