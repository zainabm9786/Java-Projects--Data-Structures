import java.util.*;

public class DSCPEXTRA {
    public static void main(String[] args) throws java.lang.Exception {

        Scanner in = new Scanner(System.in);
        System.out.println("enter number of elements to sort");
        int n = in.nextInt();
        int number_of_iterations = 1000;
        sort(n, number_of_iterations);


    }

    public static void sort(int n, int number_of_iterations) {
        Random r = new Random();
        int c, d, swap;
        long running_time = 0, total_time = 0;
        int i = 0;


        for (i = 0; i < number_of_iterations; i++) {
            int array[] = new int[n];
            for (c = 0; c < n; c++){array[c] = r.nextInt();}
            /*System.out.println("Unsorted array :");
            for (c = 0; c < n; c++)
                System.out.println(array[c]);*/
            long startTime = System.nanoTime();
            bubble_sort(array);
            long endTime = System.nanoTime();
            System.out.println("Bubble Sorted array :");
            for (c = 0; c < n; c++){System.out.println(array[c]);}
            running_time = endTime - startTime;
            total_time = total_time + running_time;
        }
        long total_time1 = total_time;
       // System.out.println("IM HEREEEEEE");
        total_time = 0;

        for (i = 0; i < number_of_iterations; i++) {
            int array1[] = new int[n];

            for (c = 0; c < n; c++)
                array1[c] = r.nextInt();
/*
            System.out.println("Unsorted array :");

            for (c = 0; c < n; c++)
                System.out.println(array1[c]);*/
            long startTime1 = System.nanoTime();

            selection_sort(array1);
            long endTime1 = System.nanoTime();

            System.out.println("Selection Sorted array :");
            running_time = endTime1 - startTime1;
            total_time = total_time + running_time;

            for (c = 0; c < n; c++)
                System.out.println(array1[c]);
        }
        System.out.println("total time for Bubble Sort= " + total_time1 + " nanoseconds");
        System.out.println("Average running time for each array in Bubble Sort = " + (total_time1 / number_of_iterations) + " nanoseconds");

        System.out.println("total time for Selection Sort= " + total_time + " nanoseconds");
        System.out.println("Average running time for each array in Selection Sort= " + (total_time / number_of_iterations) + " nanoseconds");

    }

    public static void bubble_sort(int array[]) {
        int n = array.length;
        int c = 0, d = 0, swap;
        for (c = 0; c < (n - 1); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (array[d] > array[d + 1]) {
                    swap = array[d];
                    array[d] = array[d + 1];
                    array[d + 1] = swap;
                }
            }
        }
    }

    public static void selection_sort(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
