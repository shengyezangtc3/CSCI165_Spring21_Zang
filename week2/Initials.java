/*
    Author: Shengye Zang
    Date: 2/9/2021
    Assignment: lab 2
*/

public class Initials {
    public static void main(String[] args) {
        
        String fullName = args[0] + " " + args[1];
        char firstChar = fullName.charAt(0);
        int index = fullName.indexOf(' ');
        char lastChar = fullName.charAt(index + 1);

        System.out.printf("The first character of your first name is: %c%nIts Unicode value is: %d%n", firstChar, (int) firstChar);
        System.out.printf("The first character of your last name is: %c%nIts Unicode value is: %d%n", lastChar, (int) lastChar);
        System.out.printf("The sum of these two Unicode values is: %d%n", firstChar + lastChar);
        System.out.printf(firstChar + " " + lastChar);
        
    }
}
