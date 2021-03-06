/**
 * Author: Shengye Zang
 * Date: March 5 2020
 * Assignment: Week 5 Lab
 */

import java.util.Random;
import java.util.Arrays;
import java.lang.Math;

public class SolitaireCipher{

    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";             // plain text alphabet
        int[]  cardDeck = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16, // "card deck". Joker A = 27, Joker B = 28
                            17,18,19,20,21,22,23,24,25,26,27,28};
        
        // need to repeart steps 1-5 if step 5 returns 0
        String original_message = args[0];
        String choice = args[1];
        int text_length = original_message.length();
        
        String prepared_message = prepareMessage(original_message);
        int[] key_stream = generateKeystream(cardDeck, text_length);

        if(choice.equals("e")) {
            encode(prepared_message, key_stream);
        }
        else if(choice.equals("d")) {
            decode(prepared_message, key_stream);
        }
        else 
            System.out.println("Invalid choice.");
        
    }
    
    /**
     * Prepares the "A" Joker for keystream generation
     * Finds 27 and exchanges it with card after
     * Calls the helper method "find"
     * @param deck
     */
    public static void exchangeAJoker(int[] deck){          // implements step 1 in keystream generation 
        int position = findCard(deck, 27);                  // call helper

        int temp = deck[position];                          // copy A Joker to temp location
                                  
        deck[position] = deck[(position + 1) % deck.length];// move "after" card. Up one position. Handle loop
        deck[(position + 1) % deck.length] = temp;          // place A Joker down one position. Handle loop
    }

    /**
     * Prepares the "B" Joker for keystream generation
     * Finds 28 and exchanges with two cards after
     * @param deck
     */
    public static void exchangeBJoker(int[] deck){          // implements step 2 in keystream generation 
        int position = findCard(deck, 28);                  // call helper

        int temp = deck[position];                          // copy B Joker to temp location

        // exchange items, handling loop
        deck[position] = deck[(position + 1) % deck.length]; // swap first item
        deck[(position + 1) % deck.length]  = deck[(position + 2) % deck.length];// swap second item
        deck[(position + 2) % deck.length]  = temp;          // place A Joker down one position
    }

    // TO DO: Finish these methods
    /**
     * This method randomize the deck
     * @param deck
     */
    public static void shuffleDeck(int[] deck){
        int[] temp = deck;
        Random next = new Random();
        
        for(int i=0; i<temp.length; i++) {
            int nextInt = next.nextInt(deck.length);
            int tempInt = temp[nextInt];
            temp[nextInt] = temp[i];
            temp[i] = tempInt;
        }
        deck = temp;
    }
    
    /**
     * This method implements step 3
     * @param deck
     */
    public static void tripleCut(int[] deck){
        int first = Math.min(findCard(deck, 27), findCard(deck, 28));
        int second = Math.max(findCard(deck, 27), findCard(deck, 28));
        
        int[] aboveFirst = Arrays.copyOfRange(deck, 0, first);
        int[] belowSecond = Arrays.copyOfRange(deck, second+1, deck.length);
        int[] unchanged = Arrays.copyOfRange(deck, first, second+1);
        for(int i=0; i<belowSecond.length; i++) 
            deck[i] = belowSecond[i];
        
        for(int i=0; i<unchanged.length; i++) 
            deck[i+belowSecond.length] = unchanged[i];
        
        for(int i=0; i<aboveFirst.length; i++) 
            deck[i+belowSecond.length+unchanged.length] = aboveFirst[i];
        
    }
    /**
     * This method implements step 4
     * @param deck
     */
    public static void sliceFront(int[] deck){
        int bottom = deck[deck.length-1];
        if(deck[deck.length-1] == 28)
            bottom = 27;
        int[] top = Arrays.copyOfRange(deck, 0, bottom);
        int[] left = Arrays.copyOfRange(deck, bottom, deck.length);
        for(int i=0; i<left.length; i++) 
            deck[i] = left[i];
        for(int i=0; i<top.length; i++)
            deck[i+left.length] = top[i];
    }     
    
    /**
     * This method implements step 5, return 0 if the card is a joker
     * @param deck
     * @return
     */
    public static int generateKeystreamValue(int[] deck){ 
        int keyStreamValue = 0;
        int top = deck[0];

        if(deck[0] == 28)
            top = 27;
        if(deck[top]==27 || deck[top]==28) 
            return keyStreamValue;
        
        keyStreamValue = deck[top];
        return keyStreamValue;
    }  
    /**
     * This method generates an array of key stream values with the same length as the original text
     * @param deck
     * @param length
     * @return
     */
    public static int[] generateKeystream(int[] deck, int length){
        int[] keystream = new int[length];
        for(int i=0; i<length; i++) {
            shuffleDeck(deck);
            exchangeAJoker(deck);
            exchangeBJoker(deck);
            tripleCut(deck);
            sliceFront(deck);
            while(generateKeystreamValue(deck) == 0) {
                shuffleDeck(deck);
                exchangeAJoker(deck);
                exchangeBJoker(deck);
                tripleCut(deck);
                sliceFront(deck);
            }
            keystream[i] = generateKeystreamValue(deck);
        }
        return keystream;
    }
    /**
     * Removes all non-alpha characters from message, applies uppercase, pads to factors of 5
     * @param message
     * @return
     */
    public static String prepareMessage(String message){    
        String prepared = "";
        int index = 0;
        char current;
        while(index<message.length()) {
            current = message.charAt(index);
            if(current>=65 && current<=90)
                prepared += current;
            if(current>=97 && current<=122)
                prepared += (char) (current - ('a' - 'A'));
            if(prepared.length() % 6 == 0)
                prepared += " ";
            index++;
        }  
        prepared = prepared.substring(1);                          
        return prepared;                                    
    }
    /**
     * This method applies encoding to message
     * @param message
     * @param key_stream
     * @return
     */
    public static String encode(String message, int[] key_stream){            
        String encoded = "";
        int[] temp = new int[message.length()];
        int index = 0;
        int text_length = message.length();
        while(index<text_length) {
            temp[index] = (int) (message.charAt(index) - 'A' + 1);
            temp[index] = (temp[index] + key_stream[index]) % 26;
            encoded += (char) (temp[index] + 'A' - 1);
        }
        
        return encoded;
    }  
    /**
     * This method applies decoding to message
     * @param message
     * @param key_stream
     * @return
     */
    public static String decode(String message, int[] key_stream){            
        String decoded = "";
        int[] temp = new int[message.length()];
        int index = 0;
        int text_length = message.length();
        while(index<text_length) {
            temp[index] = (int) (message.charAt(index) - 'A' + 1);
            temp[index] = (temp[index] - key_stream[index]) % 26;
            decoded += (char) (temp[index] + 'A' - 1);
        }

        return decoded;
    } 

    
    // HELPER METHODS: Define your helpers below here
    /**
     * finds the position of the specified card 
     * @param deck
     * @param card
     * @return
     */
    public static int findCard(int[] deck, int card){
        for(int index = 0; index < deck.length; ++index)
            if(deck[index] == card)
                return index;
        return -1;  // didn't find it. Should not need this, but compiler wants it.
    }
}