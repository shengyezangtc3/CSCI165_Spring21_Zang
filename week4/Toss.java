/**
 * Author: Shengye Zang
 * Date: Feb 27 2020
 * Assignment: Week 4 Discussion
 */

 import java.util.Random;
 import java.util.Arrays;

public class Toss {
    public static void main(String[] args) {
        
        int[] toss = tosses(100);
        longestRun(toss, runs(toss));
        for(int i=0; i<30; i++) {
            System.out.print(getLongest(toss) + " ");
        }
        System.out.println("We can see that the length of the longest run with highest frequency is 2 when count=100");
        
    }

    /**
     * This method simulates the tossing of a 6 sided die.
     * @param count number of tosses
     * @return the result of tossing
     */
    public static int[] tosses(int count) {
        int[] result = new int[count];
        Random die = new Random();
        for(int i=0; i<count; i++) {
            result[i] = die.nextInt(6) + 1;
        }
        return result;
    }

    /**
     * This method accepts the array of dice tosses and creates an array that stores all of the start and 
     * end points of each run.
     * @param tosses
     * @return
     */
    public static int[] runs(int[] tosses) {
        int[] runs_index = new int[tosses.length];
        int i = 0;
        for(int index=0; index<tosses.length-1; index++) {
            if(tosses[index] == tosses[index+1]) {
                runs_index[i] = index;
                int next = getRuns(Arrays.copyOfRange(tosses, index, tosses.length));
                runs_index[i+1] = index + next;
                i += 2;
                index += next - 1;
            }
                
        }
        return runs_index;
    }

    /**
     * This is a helper method for runs.
     * @param tosses
     * @return the difference between the last index of the first run and the first index of the first run of 
     * the input array
     */
    public static int getRuns(int[] tosses) {
        int length = 0;
        int index = 0;
        while(tosses[index] == tosses[index+1]) {
            length++;
            if(index == tosses.length-2)
                return length;
            index++;
        }
        return length;
    }

    /**
     * This method determines which run is the longest and displays the starting and ending indexes for the longest run, 
     * and the value in the longest run.
     * @param tosses
     * @param runs
     */
    public static void longestRun(int[] tosses, int[] runs) {
        int longest = 0;
        int start = 0;
        int end = 0;
        int index = 0;
        int length;
        while(index<runs.length && runs[index] != runs[index+1]) {
            length = runs[index+1]-runs[index];
            if(length > longest) {
                longest = length + 1;
                start = runs[index];
                end = runs[index+1];
            }
            index += 2;
        }
        System.out.printf("Starting index: %d Ending index: %d%n", start, end);
        System.out.println("The length of the longest run is: " + longest);
    }

    public static int getLongest(int[] runs) {
        int longest = 0;
        int index = 0;
        int length;
        while(index<runs.length && runs[index] != runs[index+1]) {
            length = runs[index+1]-runs[index];
            if(length > longest) {
                longest = length + 1;
            }
            index += 2;
        }
        return longest;
    }
}
