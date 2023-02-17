import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DSCProject {
    static Scanner sc = new Scanner(System.in);
    static int[] array;

    public static void main(String[] args) {
        System.out.println("Please enter a array size: ");
        int size = sc.nextInt();
        sortArray(size);
    }

    public static void sortArray(int size) {
        long running_time = 0, total_time = 0, end_time = 0, start_time, total_timeBS = 0, total_timeSS = 0;
        int num_of_iterations = 0;
        int num_of_iterations2=0;
        for (int i = 0; i < 1000; i++) {
            int[] newArray = new int[size];
            Random r = new Random();
            for (int j = 0; j < newArray.length; j++) {
                int rand_int1 = r.nextInt(size * 10);
                newArray[j] = rand_int1;
            }
            start_time = System.nanoTime();
           bubbleSortArray(newArray);

            end_time = System.nanoTime();//this too
            running_time = end_time - start_time;
            total_time = total_time + running_time;
        }

        total_timeBS = total_time;
        total_time = 0;
        for (int i = 0; i < 1000; i++) {
            int[] newArray = new int[size];
            Random r = new Random();
            for (int j = 0; j < newArray.length; j++) {
                int rand_int1 = r.nextInt(size * 10);
                newArray[j] = rand_int1;
            }

            start_time = System.nanoTime();
           selectionSortArray(newArray);
            end_time = System.nanoTime();
            running_time = end_time - start_time;
            total_time = total_time + running_time;
        }
     //   total_timeSS = total_time;

        System.out.println("Total time in Nanoseconds for Bubble Sort: " + total_timeBS) ;
        System.out.println("Average time in Nanoseconds for Bubble Sort: " + total_timeBS / 1000);
        System.out.println("\nTotal time in Nanoseconds for Selection Sort: " + total_time );
        System.out.println("Average time in Nanoseconds for Selection sort: " + total_time / 1000);

    }

    public static void bubbleSortArray(int[] array) {
        int length = array.length, holder;
        int counter=0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < (length - i); j++) {
                if (array[j - 1] > array[j]) {
                    holder = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = holder;
                    counter++;
                }
            }
        }
  //      System.out.println("Number of iterations :"+counter);
    }

    public static void selectionSortArray(int[] array) {
        int x = array.length, minimum,count = 0;
        for (int i = 0; i < x; i++) {
            minimum = i;
            for (int j = 1 + i; j < x; j++) {
                if (array[j] < array[minimum]) {
                    minimum = j;
                    count++;
                }
            }
            int temp = array[minimum];
            array[minimum] = array[i];
            array[i] = temp;
        }
    //    System.out.println("Number of iterations SS :"+count);
    }
}
