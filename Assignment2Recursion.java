/*Name: Zainab Mohammed
        Class: CS 3305/W01
        Term: Fall 2022
        Instructor: Sharon Perry
        Assignment: 2 – Part 2 Recursion*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Assignment2Recursion {
    public static void main(String[] args) throws IOException {
     /*   Scanner sc = new Scanner(System.in);
        int x;
        do {
            System.out.print("Enter a non-negative integer: ");
            x = sc.nextInt();
        } while (x < 0);
        System.out.println("");
        recursion(x, 1, "");*/
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int i=0;
        // String [] array=new String [];
        while ((line = in.readLine()) != null) {
            int a=Integer.parseInt(line);
            if (Math.sqrt(a)==Math.pow(Math.sqrt(a),2)){
                System.out.println("true");
            }
            else { System.out.println("false");}
            //  System.out.println(line);
        }
    }

    public static void recursion(int x, int num, String tab) {
        if (x == 0) {
            return;
        }
        System.out.println(tab + "This was written by call number " + num + ".");
        recursion(x - 1, num + 1, tab+"\t");
        System.out.println(tab + "This was ALSO written by call number " + num + ".");
    }
}
