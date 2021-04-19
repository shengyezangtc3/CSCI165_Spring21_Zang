/**
 * Author: Shengye Zang
 * Date: April 17, 2021
 * Assignment: Week 11 Lab
 */

public class CheckingAccount extends Account {
    private double limit;

    // constructors
    public CheckingAccount(int accountNumber, Customer owner, Date created, double balance, double limit){
        super(accountNumber, owner, created, balance);
        this.limit = limit;
    }

    public CheckingAccount(int accountNumber, Employee manager, Customer owner, Date created, double limit) {
        super(accountNumber, manager, owner, created);
        this.limit = limit;
    }

    public CheckingAccount(CheckingAccount toCopy) {
        this(toCopy.getAccountNumber(), toCopy.getCustomer(), toCopy.getDateCreated(), toCopy.getBalance(), toCopy.limit);
    }

    public double getLimit() {
        return limit;
    }

    @Override
    public boolean isInOverDraft() {
        if (getBalance() < 0) return true;
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\nOverdraft limit: " + limit;
    }

    @Override
    public boolean equals(Object other) {
        if (!super.equals(other)) return false;
        CheckingAccount account = (CheckingAccount) other;
        return limit == account.limit;
    }
}
