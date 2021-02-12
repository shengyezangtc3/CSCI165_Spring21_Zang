import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerIssues{

    public static void main(String[] args) {
        String  name    = "";   
        int     age     = 0;
        String  stonk   = "";
        double  value   = 0.0;

        try{                                        // must use exception handling when opening file
            File file = new File("data.txt");       // create a File instance
            Scanner scanner = new Scanner(file);    // Create a Scanner instance to scan the file

            while(scanner.hasNext()){               // while loop based on the presence of data in the stream
                name    = scanner.nextLine();   // nextLine reads entire line, including spaces.
                age     = scanner.nextInt();
                scanner.skip("\r\n");
                stonk   = scanner.nextLine();
                value   = scanner.nextDouble();
                scanner.skip("\r\n");
                double interest = value * 0.1;

                System.out.printf("%s will be %d and earn %.2f in interest from %s after one year%n", name, age, interest, stonk);                // print the result here            
            } // end while

            scanner.close();                        // don't forget to close the scanner
            
        }catch(FileNotFoundException fnf){          // Exception may be thrown by file opening
            System.out.println("There was a problem opening the file");
        } // end catch
    } // end main
} // end class