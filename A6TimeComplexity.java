//Name: Zainab Mohammed
// Assignment: 06-Part-2.1-Time

import java.time.LocalDateTime;
import java.time.LocalTime;
public class A6TimeComplexity {
    public static void main (String [] args){
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime currentTime = dateTime.toLocalTime();//no loops hear; just a line for conversion
        System.out.println("The current time is: "+currentTime);
        //this time complexity is O(1) since no loops were used.
        //the time is constant
    }
}
