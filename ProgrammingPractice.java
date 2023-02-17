//Declare your imports
//Create your public class and main method
//Declare needed variables
//Create menu options (with option to Quit)
//Ask user to make choice and read input from keyboard
//While user input is valid, perform task specified - write something to screen
//If user input is invalid, write message notifying invalid input
//Stop the program when user enters quit option

/*
import java.util.*;
public class ProgrammingPractice {
    public static void main(String []args) throws InputMismatchException{
        Scanner sc=new Scanner(System.in);
        int x=0;
        while (true){
      do {
          System.out.println("\nHere's the menu:" +
                  "\n1: Play soccer" +
                  "\n2: Play basketball" +
                  "\n3: Play Tennis" +
                  "\n4: Play volleyball" +
                  "\n5: Quit");
          System.out.println("Enter option: ");
          x = sc.nextInt();
          if (x==1||x==2||x==3||x==4||x==5){
              break;
          }
          else {
              System.out.println("Please put valid input!");
          }
      }while (true);
      switch(x){
          case 1:
              System.out.println("Playing soccer");
              break;
          case 2:
              System.out.println("Playing basketball");
              break;
          case 3:
              System.out.println("Playing tennis");
              break;
          case 4:
              System.out.println("Playing volleyball");
              break;
          case 5:
              System.out.println("Goodbye!");
              System.exit(0);
              break;
      }
    }}
}
*/

import java.util.*;
import java.util.LinkedList;

public class ProgrammingPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //- creates an array list filled with numbers and inserts new elements into specified locations in the list.
        // - creates a linked list from the array list and inserts and removes elements from the list
        // - traverses the list forward and backward.
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        integerArrayList.add(0, 1);
        integerArrayList.add(1, 2);
        integerArrayList.add(2, 3);
        integerArrayList.add(3, 4);
        integerArrayList.add(4, 5);
        integerArrayList.add(5, 6);
        integerArrayList.add(6, 45);
        integerArrayList.add(7, 232);
        integerArrayList.add(8, 42);
        integerArrayList.add(9, 55);
        integerArrayList.add(10, 64);
        System.out.println("Here's the list: ");

            System.out.println(integerArrayList);

            //LinkedList <Integer>linkedList = new LinkedList<Integer>();
            for (int x : integerArrayList) {// or instead of this can use linkedList.addAll(integerArrayList);
                linkedList.add(x);
            }
            while(true) {
            System.out.println("\nChoose: \n1- Add element to LinkedList " +
                    "\n2- Remove Element from LinkedList " +
                    "\n3- Traverses list forward \n4- Traverses list Backwards " +
                    "\n5- Quit");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Which number should be Inserted into list:");
                int insertNum = sc.nextInt();
                linkedList.add(insertNum);
            } else if (option == 2) {
                System.out.println("Remove elements from list:");
                int removeNum = sc.nextInt();
                linkedList.remove(Integer.valueOf(removeNum));
            } else if (option == 3) {
                for (Iterator i = linkedList.iterator(); i.hasNext();) {
                    System.out.print(i.next() +", ");
                }
            } else if (option == 4) {
                Iterator<Integer> x = linkedList.descendingIterator();
                while (x.hasNext()) {
                    System.out.print(x.next() +", ");
                }
            } else if (option == 5) {
                System.exit(0);
            } else {
                System.out.println("Choose valid option");
            }

        }
    }
}
