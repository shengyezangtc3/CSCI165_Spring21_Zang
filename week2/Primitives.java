/*
    Author: Shengye Zang
    Date: 2/9/2021
    Assignment: lab 2
*/


public class Primitives{
    
    public static void main(String[] args) {
        // Problem 1
        int a = 10;
        double b = 1.1;
        char c = 'a';
        boolean d = true;

        System.out.printf("This is an integer: %d%n", a);
        System.out.printf("This is a floating point number: %f%n", b);
        System.out.printf("This is a character: %c%n", c);
        System.out.printf("Its value is: %d%n", (int) c);
        System.out.printf("This is a boolean: %b%n", d);

        // Problem 2
        System.out.println(a + c); // It is an implicit widening cast that converts a char type to int type.
        System.out.println((int) b); // It is an explicit narrowing cast that converts a double type to int type. Value after the decimal point is lost during this cast.
        
        // Problem 3
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        System.out.printf("The max value of type int is: %d%nThe min value of type int is: %d%n", maxInt, minInt);

        // Problem 4
        long maxLong = Long.MAX_VALUE;
        long minLong = Long.MIN_VALUE;
        System.out.printf("The max value of type long is: %d%nThe min value of type long is: %d%n", maxLong, minLong);
        System.out.printf("The difference between the max value of long and int is: %d%n", maxLong - maxInt);

        // Problem 5
        int numEntered = Integer.parseInt(args[0]);
        int square = (int) Math.pow(numEntered, 2);
        int cube = (int) Math.pow(numEntered, 3);
        int fourthPow = (int) Math.pow(numEntered, 4);
        System.out.printf("The square of the number you entered is: %d%n", square);
        System.out.printf("The cube of the number you entered is: %d%n", cube);
        System.out.printf("The fourth power of the number you entered is: %d%n", fourthPow);

        // Problem 6
        int dividend = Integer.parseInt(args[1]);
        int divisor = Integer.parseInt(args[2]);
        double quotient = Math.floor((double) dividend / divisor);
        double modulus = Math.floor((double) dividend % divisor);

        System.out.printf("The quotient of the two numbers you entered is: %f%n", quotient);
        System.out.printf("The floor modulus of the two numbers you entered is: %f%n", modulus);
    }
    
}