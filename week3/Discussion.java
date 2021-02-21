/**
 * Author: Shengye Zang
 * Date: Feb 20 2020
 * Assignment: Week 3 Discussion
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Discussion {
    static String alphabet = "*BEA@FK%RM";
    public static void main(String[] args) {
        
        // problem 1
        String input;
        int temp; 
        
        String output = "";
        
        // Use try/catch to handle the potential exception. Give a warning if the entered value is not an integer
        try{
            input = args[0];
            for(int i=0; i<input.length(); i++) {
                temp = Integer.parseInt(input.substring(i, i+1)); // stores each digit of the input temporarily
                output += alphabet.charAt(temp);
            }
            System.out.println("Your number after transiletration is: " + output);
        }
        catch(InputMismatchException ime){
            System.out.println("There was a problem with the command line args. Using literals instead");
        }

        
        // problem 2
        try {
            // Create input and output files. Read in the input file.
            File input_file  = new File("numbers.txt");
            File output_file = new File("encodedNumbers.txt");
            Scanner scanner = new Scanner(input_file);
            FileWriter translated = new FileWriter(output_file);

            String next_line = "";
            String translated_line = "";
            String first_line = scanner.nextLine(); // I use this variable to skip the first line of numbers.txt

            // read in next line, translate it with the helper method, then write it to the output file
            while(scanner.hasNext()) {
                next_line = scanner.nextLine();
                translated_line = translate(next_line);
                translated.write(translated_line + "\n");
            }
            
            // close them
            scanner.close();
            translated.close();

        }
        // Identfy if a file could not be opened
        catch(FileNotFoundException fnfe) {
            System.out.println("Input file could not be opened.");
        }
        // catch the problem of IO
        catch (IOException ioe){
            System.out.println("There was a problem with an I/O operation");
        }
    }
    
    /**
     * This is a helper method that translates the argument into KenSpeak.
     * @param original
     * @return translated string
     */
    public static String translate(String original) {
        String output = "";
        for(int i=0; i<original.length(); i++) {
            int temp = Integer.parseInt(original.substring(i, i+1)); // stores each digit of the input temporarily
            output += alphabet.charAt(temp);
        }
        return output;
    }
    
}
