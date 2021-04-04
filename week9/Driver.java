/**
 * Author: Shengye Zang 
 * Date: April 1, 2021 
 * Assignment: Week 9 Lab
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
        Order order1 = new Order(customer1);

        System.out.println("What would you like to order?(Enter q to quit)");
        String input = scan.nextLine();
        int quantity;
        while (!input.equals("q")) {
            System.out.println("How many would you like to order?");
            quantity = Integer.parseInt(scan.nextLine());
            for(MenuItem item: menuItems) {
                if(item.getName().equals(input)) 
                order1.addItem(item, quantity);
            }
            System.out.println("Please enter the name of the item:(Enter q to quit)");
            input = scan.nextLine();
        }
        System.out.println("Here is your receipt.");
        order1.writeToFile();
        /*
        int itemNum = Integer.parseInt(scan.nextLine());
        String [] order = new String[itemNum];
        for(int i=0; i<itemNum; i++) {
            System.out.println("Please enter the name of the item:");
            String item = scan.nextLine();
            order[i] = item;
        }
        */
        scan.close();
        
        
        
    }
}
