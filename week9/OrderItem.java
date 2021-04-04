/**
 * Author: Shengye Zang 
 * Date: April 1, 2021 
 * Assignment: Week 9 Lab
 */

public class OrderItem {
    private MenuItem menuItem;
    private int quantity;
    
    // Constructors
    public OrderItem() {}

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = new MenuItem(menuItem);
        setQuantity(quantity);
    }

    public OrderItem(OrderItem toClone) {
        this.menuItem = toClone.menuItem;
        this.quantity = toClone.quantity;
    }

    // Setters and Getters
    public MenuItem getMenuItem() {
        return new MenuItem(menuItem);
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0)
            this.quantity = quantity;
    }

    // Other behaviors
    public void increaseQuantity(int num) {
        if (num > 0 && this.quantity > 0) // ask about the requirement
            this.quantity += num;
    }

    public String toString() {
        return "Item: " + this.menuItem.getName() + "\nPrice: $" + this.menuItem.getPrice() + "\nQuantity: " 
                + this.quantity;
    }
    
}
