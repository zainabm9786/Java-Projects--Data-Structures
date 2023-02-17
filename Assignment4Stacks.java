// Name: Zainab Mohammed
// Assignment: 04-Part-1-Stacks

import java.util.*;

public class Assignment4Stacks {

    int top_a, top_b;
    static int[] array;

    Assignment4Stacks(int s) {// creates the array with given size
        array = new int[s];
        top_a = -1;//top_a starts at index 0
        top_b = s; //top_b starts at the size of the array-1
    }

    public void push_a(int a) {// pushes elemnt into the stack
        if (!is_full()) {//makes sure there is space for a/new element
            top_a++;//goes from left to right as a stack
            array[top_a] = a;

        } else {//if is_full==false
            System.out.println("Stack is full");
            //   System.exit(0);//exits programs
        }
    }

    public void push_b(int b) {
        if (!is_full()) {//makes sure there is space for a/new element
            top_b--;// goes from right to left as a stack
            array[top_b] = b;
        } else {//if is_full==false
            System.out.println("Stack is full");
            // System.exit(0);//exits programs
        }
    }

    public void pop_a() {
        int data;

        data = array[top_a];// can use this and change void to int and
        //make main ,method see pop value
        System.out.println(data);//data

        array[top_a] = 0;
        top_a--;
    }

    public void pop_b() {// pops value from b
        int data;
        data = array[top_b];// can use this and change void to int and
        //make main metohod see pop value
        System.out.println(data);

        array[top_b] = 0;
        top_b++;
        //return data;
    }

    public boolean is_empty_a() {// add static or no?
        if (top_a <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean is_empty_b() {// add static or no?
        if (top_b >= array.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean is_full() {// add static or no?
        if (top_a < top_b-1 ) {// sees if stack is full
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter size of array: ");
        int size = sc.nextInt();
        Assignment4Stacks stacks = new Assignment4Stacks(size);//creates object
        System.out.println("Stack A empty: " + stacks.is_empty_a());
        System.out.println("Stack B empty: " + stacks.is_empty_b());
        while (true) {
            System.out.println("\nChoose options : \n1) Push value into Stack A  \n2) Push value into Stack B " +
                    "\n3) Pop value into Stack A \n4) Pop value into Stack B " +
                    "\n5) See if Stack is full  \n6) See if Stack A is empty \n7) See if stack B is empty \n8) Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Pushing value into Stack A: ");
                    int x = sc.nextInt();
                    stacks.push_a(x);
                    break;
                case 2:
                    System.out.print("Pushing value into Stack B: ");
                    x = sc.nextInt();
                    stacks.push_b(x);
                    break;
                case 3:
                    System.out.print("Popping value from Stack A: ");
                    stacks.pop_a();
                    break;
                case 4:
                    System.out.print("Popping value from Stack B: ");
                    stacks.pop_b();
                    break;
                case 5:
                    System.out.print("Seeing if stack is full: ");
                    System.out.println(stacks.is_full());
                    break;
                case 6:
                    System.out.print("Seeing if stack A is empty: ");
                    System.out.println(stacks.is_empty_a());
                    break;
                case 7:
                    System.out.print("Seeing if stack B is empty: ");
                    System.out.println(stacks.is_empty_b());
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid input");
                    break;
            }
        }
    }
}

