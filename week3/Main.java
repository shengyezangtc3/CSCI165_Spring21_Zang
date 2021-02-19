/** 
 * Author: Shengye Zang
 * Date: Feb 18 2021
 * Assignment: Week 3 Lab
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Integer;


public class Main{
    public static void main(String[] args) {
        
        // takes the command line argument as name of the input file and name the output file based on the name of the input file
        String inputFile = args[0];
        String outputFile = "valid_" + inputFile;
        try{
            // define File objects for each stream connection
            File input  = new File(inputFile);
            File output    = new File(outputFile);

            // define Scanner objects for the input streams
            Scanner scanner  = new Scanner(input);

            // define a FileWriter object for the output stream
            FileWriter valid_output = new FileWriter(output);

            // define all the variables I need in the while loop
            String venue           = "";
            int ticket_number      = 0;
            int last_digit         = 0;
            int drop_last          = 0;
            int num_valid          = 0;
            int num_invalid        = 0;
            double percent_valid   = 0.0;
            double percent_invalid = 0.0;
            boolean isValid        = false;

            // Use a while loop to read in the input file and write on the output file, and keep track of the number of valid and invalid tickets
            while(scanner.hasNext()){
                venue = scanner.nextLine();
                ticket_number = Integer.parseInt(scanner.nextLine());
                last_digit = ticket_number % 10;
                drop_last = ticket_number / 10;
                isValid = (drop_last % 7) == last_digit;
                if (isValid == true) {
                    valid_output.write(venue + ": " + ticket_number + "\n");
                    num_valid += 1;
                }
                else {num_invalid += 1;}
            } 

            // Compute and display percentage of valid and invalid tickets
            percent_invalid = (double) num_invalid / (num_invalid + num_valid) * 100;
            percent_valid = (double) num_valid / (num_invalid + num_valid) * 100;
            System.out.printf("The percentage of valid ticket is: %.2f%nThe percentage of invalid tickets is: %.2f%n", percent_valid, percent_invalid);

            // CLOSE STREAMS
            valid_output.close();
            scanner.close();
        
        // Identfy if a file could not be opened
        }catch(FileNotFoundException fnfe){
            System.out.println("Input file could not be opened.");
        }
        // catch the problem of IO
        catch (IOException ioe){
            System.out.println("There was a problem with an I/O operation");
        }
    }
}