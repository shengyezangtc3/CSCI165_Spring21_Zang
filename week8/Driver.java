/**
 * Author: Shengye Zang
 * Date: March 25, 2021
 * Assignment: Week 8 Lab
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static ArrayList<MenuItem> loadMenuItems(String fileName) {
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        try{
            File file = new File(fileName);                          
            Scanner scanner = new Scanner(file);                     

            while(scanner.hasNext()){
                String line     = scanner.nextLine();               
                String[] fields = line.split(",");       
                // Since the result of using split is a String array, we need to parse the strings into
                // the types we need for the MenuItem constructor           
                MenuItem temp = new MenuItem(fields[0], Double.parseDouble(fields[1]), Integer.parseInt(fields[2]));
                menuItems.add(temp);
            }
            scanner.close();
           
        }catch(FileNotFoundException fnfe){
            System.out.println(fileName + " NOT FOUND! Check your data");
        }

        return menuItems;
    }

    public static void printMenu(ArrayList<MenuItem> menuItems) {
        System.out.println("Food Truck Menu");
        for(MenuItem current: menuItems) {
            System.out.println(current);
        }
    }

    /**
     * This method takes an arraylist for the menu containing all items, and an array of strings containing the names of the items ordered.
     * @param menuItems
     * @param order
     * @return an arraylist of the items ordered.
     */
    public static ArrayList<MenuItem> orderFromMenu(ArrayList<MenuItem> menuItems, String[] order) {
        ArrayList<MenuItem> orderList = new ArrayList<MenuItem>();
        
        for(MenuItem item: menuItems) {
            for(String itemName: order) {
                if(item.getName().equals(itemName)) 
                    orderList.add(item);
            }
        }
        return orderList;
    }

    public static void main(String[] args) {
        ArrayList<MenuItem> menuItems = loadMenuItems("products.txt");
        printMenu(menuItems);
        System.out.println("");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your customer information.");
        System.out.println("Name:");
        String name = scan.nextLine();
        System.out.println("Email:");
        String email = scan.nextLine();
        System.out.println("Phone number(10 digits):");
        String phone = scan.nextLine();
        Customer customer1 = new Customer(name, email, phone);

        System.out.println("How many items would you like to order?");
        int itemNum = Integer.parseInt(scan.nextLine());
        String [] order = new String[itemNum];
        for(int i=0; i<itemNum; i++) {
            System.out.println("Please enter the name of the item:");
            String item = scan.nextLine();
            order[i] = item;
        }
        scan.close();
        ArrayList<MenuItem> orderedItems = orderFromMenu(menuItems, order);
        System.out.println("");
        System.out.println("Receipt");
        System.out.println("Customer: " + customer1.getName());
        System.out.println("Items:");
        for(MenuItem item: orderedItems) {
            System.out.println(item.toString());
        }
        
    }
}
