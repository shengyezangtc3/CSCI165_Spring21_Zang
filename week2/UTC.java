/*
    Author: Shengye Zang
    Date: 2/9/2021
    Assignment: lab 2
*/

import java.util.Calendar;

public class UTC {
    public static void main(String[] args) {
        
        // Format 1
        long millis = System.currentTimeMillis(); 
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" +
      calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));

        // Format 2
        long temp = millis % (24 * 60 * 60 * 1000); // Only consider the part of time for today
        int hour = (int) temp / (60 * 60 * 1000);
        int minute = (int) (temp % (60 * 60 * 1000)) / (60 * 1000);
        int second = (int) (temp % (60 * 1000)) / 1000;
        System.out.println("Current GMT time is: " + hour + ":" + minute + ":" + second);
        
        int timeZone = Integer.parseInt(args[0]); // Input should be an integer representing local time zone
        temp = (millis + timeZone * 60 * 60 * 1000) % (24 * 60 * 60 * 1000); // Adjust to local time
        // It is a little wordy, but I recalculate the time because local time and UTC time may not be the same day
        hour = (int) temp / (60 * 60 * 1000);
        minute = (int) (temp % (60 * 60 * 1000)) / (60 * 1000);
        second = (int) (temp % (60 * 1000)) / 1000;
        System.out.println("Current local time is: " + hour + ":" + minute + ":" + second);
    }
}
