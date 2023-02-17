// Name: Zainab Mohammed
// Assignment: 04-Part-2-Palindromes

import java.util.*;

public class Assignment4Part2 {//comment code!!!!!!!!!!!

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter line to read: ");
        String line = sc.nextLine().toLowerCase();
        char[] letters = line.toCharArray();
        Stack<Character> Stack_1 = new Stack<>();//creates Stack_1
        Stack<Character> Stack_2 = new Stack<>();//creates Stack_2
        Stack<Character> Stack_3 = new Stack<>();//creates Stack_3
        // You MUST use three stacks to implement the
        //program. For simplicity use only lower case letters in your test strings.

        for (char x : letters) {
            Stack_1.push(x);//inserts/pushes line form user into Stack_1
            Stack_2.push(x);//inserts/pushes line form user into Stack_2
        }
      /*  for (Character c : Stack_1) {//another way to pop values from A into Stack C
            Stack_3.push(Stack_1.pop());
        }*/
        while (!Stack_1.empty()) {// pop values from A into Stack C
            Stack_3.push(Stack_1.pop());
        }

        if (Stack_2.equals(Stack_3)) {//compared the line in Stack_2 to Stack_3
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not a palindrome");
        }
    }
}
