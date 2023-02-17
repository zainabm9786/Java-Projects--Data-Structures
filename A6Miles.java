//Name: Zainab Mohammed
// Assignment: 06-Part-2.2-Miles

import java.util.*;

public class A6Miles {
    public static void main(String[] args) {//COMMENT CODE!!!!!!!!!!!!!!!!!

        for (int i = 0; i <= 90; i += 10) {//I used one loop for this, so it has a time complexity of O(n)
            //The complexity is linear and has a linear time
            //loop executes 10 or n times
            System.out.println("Miles: " + i + " --> Kilometers: " + convert(i));
        }//so it is O(n) for the time complexity
    }
    public static double convert(double miles) {
        return miles * 1.6;
    }
}
