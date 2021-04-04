/**
 * Author: Shengye Zang 
 * Date: April 1, 2021 
 * Assignment: Week 9 Lab
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OrderTests {
    Order order1, order2;
    OrderItem orderItem1, orderItem2;
    MenuItem item1, item2;
    Customer customer1, customer2;

    @BeforeEach
    public void setup(){
        order1 = null;
        order2 = null;
    }

    @Test
    public void testGetCustomer() {
        customer1 = new Customer("Tom", "abc@def.com", "0123456789");
        order1 = new Order(customer1);
        assertFalse(customer1 == order1.getCustomer());
        assertTrue(customer1.equals(order1.getCustomer()));
    }

    @Test
    public void testGetDate() {
        customer1 = new Customer("Tom", "abc@def.com", "0123456789");
        order1 = new Order(customer1);
        order2 = new Order(order1);
        assertFalse(order1.getDate() == order2.getDate());
        assertTrue(order1.getDate().equals(order2.getDate()));
    }

    @Test
    public void testGetCart() {
        item1 = new MenuItem("Cupcake", 3.99, 450);
        item2 = new MenuItem("Black Bean Burger", 9.99, 500);
        customer1 = new Customer("Tom", "abc@def.com", "0123456789");
        order1 = new Order(customer1);
        order1.addItem(item1, 2);
        order1.addItem(item2);
        ArrayList<OrderItem> items = new ArrayList<OrderItem>();
        orderItem1 = new OrderItem(item1, 2);
        orderItem2 = new OrderItem(item2, 1);
        items.add(orderItem1);
        items.add(orderItem2);
        assertTrue(order1.getCart().size() == items.size());
        assertFalse(orderItem1 == order1.getCart().get(0));
        assertTrue(order1.getCart().get(0).getMenuItem().equals(item1));
        assertTrue(order1.getCart().get(0).getQuantity() == orderItem1.getQuantity());
        assertFalse(orderItem2 == order1.getCart().get(1));
        assertTrue(order1.getCart().get(1).getMenuItem().equals(item2));
        assertTrue(order1.getCart().get(1).getQuantity() == orderItem2.getQuantity());
    }
}
