// Shengye Zang Lab1

public class Shapes {

    public static void main(String[] args) {
        for (int i= 5; i > -1; i-- ) {
            for (int j= 0; j < i; j++ ) {
                System.out.print("*");
            }
            System.out.println("");
        } // Printing the first shape.

        for (int i= 1; i < 6; i++ ) {
            if (i == 1 || i == 5) {
                System.out.println("*****");
            } else {
                System.out.println("*   *");
            }
        } // Printing the second shape

        System.out.println("*****");
        System.out.println(" *** ");
        System.out.println("  **");
        System.out.println(" *** ");
        System.out.println("*****"); // Printing the third shape
    }

}
