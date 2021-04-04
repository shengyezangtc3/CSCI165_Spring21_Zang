/**
 * Author: Shengye Zang 
 * Date: April 1, 2021 
 * Assignment: Week 9 Lab
 */

public class MenuItem {
    private String name;
    private double price;
    private int calories;

    public MenuItem() {}

    public MenuItem(String name, double price, int calories) {
        this.name = name;
        setPrice(price);
        setCalories(calories);
    }

    public MenuItem(MenuItem toClone) {
        this.name = toClone.name;
        this.price = toClone.price;
        this.calories = toClone.calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        if(price > 0) 
            this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setCalories(int calories) {
        if(calories >= 0)
            this.calories = calories;
    }

    public int getCalories() {
        return this.calories;
    }

    public String toString() {
        return "Name: " + this.name + " Price: $" + this.price + " Calories: " + this.calories;
    }

    public boolean equals(MenuItem otherItem) {
        return this.name.equals(otherItem.name) && this.price == otherItem.price && this.calories == otherItem.calories;
    }
}