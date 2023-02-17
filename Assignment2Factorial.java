//Name: Zainab Mohammed
//        Assignment: 2 – Part 1 Factorial

import java.util.Scanner;

public class Assignment2Factorial {
    public static void main (String [] args){// take a screenshot of output too!!
        Scanner sc=new Scanner(System.in);
        int x;
        do {
            System.out.print("Enter a non-negative integer: ");
            x = sc.nextInt();
        }while (x<0);
        System.out.println("Factorial of "+x +" is "+Factorial(x));
    }
    public static int Factorial(int x){
        if (x==1 || x==0){
            return 1;
        }
        else {
            return x * Factorial(x-1);
        }
    }
}
