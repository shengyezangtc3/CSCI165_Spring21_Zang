public class SolitaireTester {
    
    public static void main(String[] args) {
        // call testing methods
        testExchangeAJoker();
        System.out.println();
        testExchangeBJoker();
    }

    public static void testExchangeAJoker(){
        // TEST CASES

        //int[] deck      = {1,2,3,4,5,6,7,27,8,9,10};            // deck to test
        //int[] expected  = {1,2,3,4,5,6,7,8,27,9,10};            // expected results

        //int[] deck      = {1,2,3,4,5,6,7,8,9,10,27};            // deck to test
        //int[] expected  = {27,2,3,4,5,6,7,8,9,10,1};            // expected results

        //int[] deck      = {27,1,2,3,4,5,6,7,8,9,10};            // deck to test
        //int[] expected  = {1,27,2,3,4,5,6,7,8,9,10};            // expected results

        int[] deck      = {1,2,27,3,4,5,6,7,8,9,10};            // deck to test
        int[] expected  = {1,2,3,27,4,5,6,7,8,9,10};            // expected results

        // print original deck
        System.out.print("ORIGINAL DECK: ");
        printArray(deck);

        SolitaireCipher.exchangeAJoker(deck);                   // call method to test

        if(equalArrays(deck, expected))                         // call helper to check results
            System.out.println("\nexchangeAJoker: TEST PASSED!");
        else
            System.out.println("\nexchangeAJoker: TEST FAILED");

        // show results
        System.out.print("RESULT: ");
        printArray(deck);
        System.out.print("\nEXPECTED RESULT: ");
        printArray(expected);
    }

    public static void testExchangeBJoker(){
        // TEST CASES

        //int[] deck      = {1,2,3,28,4,5,6,7,8,9,10};            // deck to test
        //int[] expected  = {1,2,3,4,5,28,6,7,8,9,10};            // expected results

        //int[] deck      = {1,2,3,4,5,6,7,8,28,9,10};            // deck to test
        //int[] expected  = {1,2,3,4,5,6,7,8,9,10,28};            // expected results

        //int[] deck      = {1,2,3,4,5,6,7,8,9,28,10};            // deck to test
        //int[] expected  = {28,2,3,4,5,6,7,8,9,10,1};            // expected results

        int[] deck      = {1,2,3,4,5,6,7,8,9,10,28};            // deck to test
        int[] expected  = {2,28,3,4,5,6,7,8,9,10,1};            // expected results

        // print original deck
        System.out.print("\nORIGINAL DECK: ");
        printArray(deck);

        SolitaireCipher.exchangeBJoker(deck);                   // call method to test

        if(equalArrays(deck, expected))                         // call helper to check results
            System.out.println("\nexchangeBJoker: TEST PASSED!");
        else
            System.out.println("\nexchangeBJoker: TEST FAILED");

        // show results
        System.out.print("RESULT: ");
        printArray(deck);
        System.out.print("\nEXPECTED RESULT: ");
        printArray(expected);
    }

    public static void testShuffleDeck() {
        int[]  cardDeck = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16, // "card deck". Joker A = 27, Joker B = 28
                            17,18,19,20,21,22,23,24,25,26,27,28}; // no expectaion as the result is random
        for(int i=0; i<3; i++) {
            SolitaireCipher.shuffleDeck(cardDeck);
            printArray(cardDeck);
            System.out.println("");
        }
    }

    public static void testtripleCut() {
        // Test Cases:
        // int[] deck = {1,2,28,3,4,5,27,9};
        // int[] expected = {9,28,3,4,5,27,1,2};
        // int[] deck = {28,1,2,3,27};
        // int[] expected = {28,1,2,3,27};
        int[] deck = {1,2,3,27,4,5,28,9,10};
        int[] expected = {9,10,27,4,5,28,1,2,3};
        System.out.println("\nOriginal Deck:");
        printArray(deck);

        SolitaireCipher.tripleCut(deck);

        if(equalArrays(deck, expected))                         
            System.out.println("\nexchangeBJoker: TEST PASSED!");
        else
            System.out.println("\nexchangeBJoker: TEST FAILED");

        System.out.println("Result:");
        printArray(deck);
        System.out.println("\nExpected Result:");
        printArray(expected);
    }

    public static void testSliceFront() {
        // Test Cases:
        // int[] deck = {2,1};
        // int[] expected = {1,2};
        // int[] deck = {4,2,1,3};
        // int[] expected = {3,4,2,1};
        int[] deck = {1,2,3,4,6,5};
        int[] expected = {5,1,2,3,4,6};

        System.out.println("\nOriginal Deck:");
        printArray(deck);

        SolitaireCipher.sliceFront(deck);

        if(equalArrays(deck, expected))                         
            System.out.println("\nexchangeBJoker: TEST PASSED!");
        else
            System.out.println("\nexchangeBJoker: TEST FAILED");

        System.out.println("Result:");
        printArray(deck);
        System.out.println("\nExpected Result:");
        printArray(expected);
    }

    public static void testgenerateKeystreamValue() {
        // Test Cases:
        // int[] deck = {27,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,28};
        // int[] expected = 28;
        // int[] deck = {28,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
        // int[] expected = 27;
        int[] deck = {2,3,4,5};
        int expected = 4;

        System.out.println("\nOriginal Deck:");
        printArray(deck);

        int value = SolitaireCipher.generateKeystreamValue(deck);

        if(value == expected)                         
            System.out.println("\nexchangeBJoker: TEST PASSED!");
        else
            System.out.println("\nexchangeBJoker: TEST FAILED");

        System.out.println("Result:");
        System.out.println(value);
        System.out.println("\nExpected Result:");
        System.out.println(expected);
    }

    // HELPERS. Define any helper methods below here

    /**
     * Compares two arrays for equality, enforcing order
     * @param one
     * @param two
     * @return
     */
    public static boolean equalArrays(int[] one, int[] two){
        if(one.length != two.length)                    // not the same length?
            return false;                               // get out early

        for(int index = 0; index < one.length; ++index) // iterate through both arrays
            if(one[index] != two[index])                // compare item by item
                return false;                           // items aren't equal return false

        return true;                                    // made it here? Guaranteed equal
    }

    /**
     * prints an array on a single line, items separated by spaces
     * @param array
     */
    public static void printArray(int[] array){
        for(int element : array)                        // use an enhanced for loop. Do not need an index
            System.out.print(element + " ");            // use "print" to avoid the line break
    }
}
