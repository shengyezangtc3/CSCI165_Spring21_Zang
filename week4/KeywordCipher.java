/**
 * Author: Shengye Zang
 * Date: Feb 25 2020
 * Assignment: Week 4 Lab
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class KeywordCipher {
    final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        
        /**
         * Please enter the name of input file, your keyword, and choice of encipher or decipher in the command line
         * arguments. Please follow the order above. Choice should be either "e" or "d", which is the same as the ROT
         * class.
         */

        // check if the correct number of arguments have been entered, stops the program if not
        if(args.length != 3) {
            System.out.println("Please enter the right quantity of command line arguments.");
            return;
        }
        String file_name;
        String keyword;
        String choice;

        try {
            file_name = args[0];
            keyword = args[1];
            choice = args[2];

            String cipher_alphabet = generateCipherAlphabet(prepareKeyWord(keyword));
           
            // Create input and output files.
            File input_file  = new File(file_name);          
            File output_file = new File(name(choice, file_name));
            Scanner scanner = new Scanner(input_file);
            FileWriter enciphered = new FileWriter(output_file);
            FileWriter deciphered = new FileWriter(output_file);

            String next_line = "";
            String enciphered_line = "";
            String deciphered_line = "";

            // This loop reads in each line of the input file, enciphers it, and writes the result with the right format in the output file.
            if(choice.equals("e")) {
                while(scanner.hasNext()) {
                    next_line = scanner.nextLine().toUpperCase();
                    enciphered_line = encipher(cipher_alphabet, next_line);
                    enciphered.write(enciphered_line + "\n");
                }
            }

            // This loop reads in each line of the input file, deciphers it, and writes the result with the right format in the output file.
            if(choice.equals("d")) {
                while(scanner.hasNext()) {
                    next_line = scanner.nextLine().toUpperCase();
                    deciphered_line = decipher(cipher_alphabet, next_line);
                    deciphered.write(deciphered_line + "\n");
                }
            }
           
            // close them
            scanner.close();
            enciphered.close();
            deciphered.close();

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
     * This method accepts the keyword and removes any duplicate letters
     * @param keyword
     * @return keyword without duplicate letters
     */
    public static String prepareKeyWord(String keyword) {
        String prepared = "";
        for(int i=0; i<keyword.length(); i++) {
            String current = keyword.substring(i, i+1);
            if(!prepared.contains(current)) 
                prepared += current;
        }
        return prepared;
    }

    /**
     * This method accepts a string representing the keyword and returns a new string containing the new alphabet
     * @param prepared_keyword
     * @return ciphered alphabet
     */
    public static String generateCipherAlphabet(String prepared_keyword) {
        String cipher_alphabet = prepared_keyword.toUpperCase();
        for (int i=0; i<26; i++) {
            String current = alphabet.substring(i, i+1);
            if(!cipher_alphabet.contains(current))
                cipher_alphabet += current;
        }
        return cipher_alphabet;
    }

    /**
     * This method accepts the cipher alphabet and the string to encipher, and returns the enciphered text in the right format.
     * @param cipher_alphabet
     * @param text
     * @return
     */
    public static String encipher(String cipher_alphabet, String text) {
        String enciphered = "";
        
        // This loop does the ensiphering task and adding whitespaces as the required format.
        for(int i=0; i<text.length(); i++) {
            String current = text.substring(i, i+1);
            if(enciphered.length() % 6 == 0)
                enciphered += " ";
            if(alphabet.contains(current))
                enciphered += cipher_alphabet.charAt(alphabet.indexOf(current));
        }
        
        enciphered = enciphered.substring(1); // The above loop adds an extra whitespace at the beginning, so now I delete it
        return enciphered;
    }

    public static String decipher(String cipher_alphabet, String text) {
        String deciphered = "";
        for(int i=0; i<text.length(); i++) {
            String current = text.substring(i, i+1);
            if(deciphered.length() % 6 == 0)
                deciphered += " ";
            if(alphabet.contains(current))
                deciphered += alphabet.charAt(cipher_alphabet.indexOf(current));
        }
        return deciphered;
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
            name = file_name.substring(0, file_name.length()-4) + "_enciphered.txt";
            return name;
        }
        if(input_string.equals("d")) {
            name = file_name.substring(0, file_name.length()-4) + "_deciphered.txt";
            return name;
        }
        return name;
    }
}
