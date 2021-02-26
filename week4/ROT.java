/**
 * Author: Shengye Zang
 * Date: Feb 25 2020
 * Assignment: Week 4 Lab
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ROT{
    public static void main(String[] args) {
        
        // check if the correct number of arguments have been entered, stops the program if not
        if(args.length != 3) {
            System.out.println("Please enter the right quantity of command line arguments.");
            return;
        }
        String file_name;
        String input_string;
        int input_int;

        try {
            file_name = args[0];
            input_string = args[1];
            input_int = Integer.parseInt(args[2]);

            // check if the expected input has been entered, stops the program if not
            if((!input_string.equals("e")) && (!input_string.equals("d"))) {
                System.out.println("Invalid argument");
                return;
            }

            // check if the expected input has been entered, stops the program if not
            if(input_int != 13 && input_int != 47) {
                System.out.println("The input number should be either 13 or 47.");
                return;
            }
            
            // Create input and output files.
            File input_file  = new File(file_name);          
            File output_file = new File(name(input_string, file_name));
            Scanner scanner = new Scanner(input_file);
            FileWriter encoded = new FileWriter(output_file);

            String next_line = "";
            String encoded_line = "";

            // If ROT13 is chosen, the text of the input file needs to be converted to uppercase first, then apply ROT13.
            if(input_int == 13) {
                while(scanner.hasNext()) {
                    next_line = scanner.nextLine().toUpperCase();
                    encoded_line = applyROT(next_line, input_int);
                    encoded.write(encoded_line + "\n");
                }
            }

            // If ROT47 is chosen, apply ROT47 directly to the original text of the input file.
            if(input_int == 47) {
                while(scanner.hasNext()) {
                    next_line = scanner.nextLine();
                    encoded_line = applyROT(next_line, input_int);
                    encoded.write(encoded_line + "\n");
                }
            }
           
            // close them
            scanner.close();
            encoded.close();

        }
        catch(InputMismatchException ime){
            System.out.println("There was a problem with the command line args.");
        }
        // Identfy if a file could not be opened
        catch(FileNotFoundException fnfe) {
            System.out.println(args[0] + "does not exist.");
        }
        // catch the problem of IO
        catch (IOException ioe){
            System.out.println("There was a problem with an I/O operation");
        }
    }

    /**
     * This method takes in an argument to decide which alphabet is used. The argument should be either 13 or 47.
     * @param cipher
     * @return alphabet: the collection of characters to use for ROT encoding
     */
    public static String rotCharacterSet(int cipher) {
        String alphabet = "";
        if (cipher == 13) {
            for(int ascii= (int) 'A'; ascii<= (int) 'Z'; ascii++){
                alphabet += (char) ascii; // get the right ASCII number
            }
        }
        if (cipher == 47) {
            for(int ascii= (int) '!'; ascii<= (int) '~'; ascii++){
                alphabet += (char) ascii; // get the right ASCII number
            }
        }
        return alphabet;
    }

    /**
     * This method takes in the text and chosen cipher to encode the text
     * @param text
     * @param cipher
     * @return encoded text
     */
    public static String applyROT(String text, int cipher) {
        String alphabet = rotCharacterSet(cipher);
        String encoded = "";
        for(int i=0; i<text.length(); i++) {
            String current = text.substring(i, i+1);
            if(alphabet.contains(current)) {
                int index = (alphabet.indexOf(current) + cipher) % (cipher * 2); // just take the remainder of the length of an alphabet, which equals cipher * 2
                current = alphabet.substring(index, index + 1);
            }
            encoded += current;
        }
        return encoded;
    }

    /**
     * This method creates the name of the output file according to the input string
     * @param input_string
     * @param file_name
     * @return the name of the output file
     */
    public static String name(String input_string, String file_name) {
        String name = "";
        if(input_string.equals("e")) {
            name = file_name.substring(0, file_name.length()-4) + "_encrypted.txt";
            return name;
        }
        if(input_string.equals("d")) {
            name = file_name.substring(0, file_name.length()-14) + ".txt";
            return name;
        }
        return name;
    }
}