/**
 * Author: Shengye Zang 
 * Date: April 1, 2021 
 * Assignment: Week 9 Lab
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Order {
    private Date date;
    private String invoiceID;
    private Customer customer;
    private ArrayList<OrderItem> cart = new ArrayList<OrderItem>();

    // Constructors
    public Order() { 
        setDate();
    }

    public Order(Customer customer) { 
        this.customer = new Customer(customer);
        setDate();
        createInvoiceID();
    }

    public Order(Order toClone) {
        this.date = new Date(toClone.getDate());
        this.invoiceID = toClone.invoiceID;
        this.customer = new Customer(toClone.customer);
        this.cart = toClone.getCart();
    }

    // Getters and setters
    public Date getDate() {
        return new Date(this.date);
    }

    public String getInvoice() {
        return this.invoiceID;
    }

    public Customer getCustomer() {
        return new Customer(this.customer);
    }

    public ArrayList<OrderItem> getCart() {
        return new ArrayList<OrderItem>(this.cart);
    }

    private void setDate() {
        LocalDateTime currentTime = LocalDateTime.now();
        Date newDate = new Date(currentTime.getMonthValue(), currentTime.getDayOfMonth(), currentTime.getYear());
        this.date = newDate;
    }

    // Other behaviors
    public void addItem(MenuItem item) {
        if (this.cart == null) {
            OrderItem newItem = new OrderItem(item, 1);
            this.cart.add(newItem);
        }
        for(int i=0; i<this.cart.size(); i++) {
            OrderItem current = this.cart.get(i);
            if (current.getMenuItem().equals(item)){
                current.increaseQuantity(1);
                return;
            }
        }
        OrderItem newItem = new OrderItem(item, 1);
        this.cart.add(newItem);
    }

    public void addItem(MenuItem item, int quantity) {
        if (this.cart == null) {
            OrderItem newItem = new OrderItem(item, quantity);
            this.cart.add(newItem);
            return;
        }
        for(int i=0; i<this.cart.size(); i++) {
            OrderItem current = this.cart.get(i);
            if (current.getMenuItem().equals(item)){
                current.increaseQuantity(quantity);
                return;
            }
        }
        OrderItem newItem = new OrderItem(item, quantity);
        this.cart.add(newItem);
    }

    public double calculateTotal() {
        double sum = 0.0;
        for (int i=0; i<this.cart.size(); i++) {
            OrderItem current = this.cart.get(i);
            sum += current.getMenuItem().getPrice() * current.getQuantity();
        }
        return sum;
    }

    public double calculateTax(double total) {
        double tax = 0.0;
        final double TAX_RATE = 0.08;
        tax += total * TAX_RATE;
        return tax;
    }

    public void writeToFile() {
        try {
            File outpuFile = new File(this.invoiceID + ".txt");
            FileWriter receipt = new FileWriter(outpuFile);
            receipt.write(toString());
            receipt.close();
        }
        catch (IOException ioe) {
            System.out.println("Invalid IO");
        }
    }

    private void createInvoiceID() {
        String invoice;
        String[] name = customer.getName().split(" ");
        String initials = name[0].substring(0, 1) + name[1].substring(0, 1);
        int num = (name[0].charAt(0) + name[1].charAt(0)) * customer.getName().length();
        invoice = initials + num + this.date.getMonth() + this.date.getDay() + this.date.getYear();
        this.invoiceID = invoice;
    }

    public String toString() {
        String output = "Date: " + this.date.toString() + "\nOrder ID: " + this.invoiceID + "\nCustomer: " + this.customer.toString();
        for (int i=0; i<this.cart.size(); i++) {
            output += "\n" + this.cart.get(i).toString();
        }
        double tax = calculateTax(calculateTotal());
        output += "\nTax: $" + String.format("%.2f", tax) + "\nTotal: $" + String.format("%.2f", calculateTotal() + tax); 
        return output;
    }

    public boolean equals(Order otherOrder) {
        for (int i=0; i<this.cart.size(); i++) {
            OrderItem current = this.cart.get(i);
            OrderItem other = otherOrder.cart.get(i);
            if (current.getQuantity() != other.getQuantity() || !current.getMenuItem().equals(other.getMenuItem())) {
                return false;
            }
        }
        return this.date.equals(otherOrder.date) && this.invoiceID.equals(otherOrder.invoiceID) 
               && this.customer.equals(otherOrder.customer);
    }

    public int compareTo(Order otherOrder) {
        return this.date.compareTo(otherOrder.date);
    }
}