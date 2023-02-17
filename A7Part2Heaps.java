// Name: Zainab Mohammed
// Class: CS 3305/ W01
// Term: Fall 2022
// Instructor: Sharon Perry
// Assignment: 7-Part-2-Heaps

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class A7Part2Heaps {
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap of integers
        Heap<E> heap = new Heap<>();
        // Add elements to the heap
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }
        // Remove elements from the heap
        for (int i = 0; i <list.length ; i++) {
            list[i] = heap.remove();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] list = new Integer[5];
        for (int i = 0; i < 5; i++) {//Write a main method that will accept 5 numbers, and put them in a min-heap
            System.out.println("Enter a number: ");
            int num = sc.nextInt();
            list[i] = num;
        }
        heapSort(list);

        System.out.println(Arrays.toString(list));
    }
}

///////////////////////////////////////////////////////
class Heap<E extends Comparable<E>> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public Heap() {
    }

    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    public void add(E newObject) {
        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is less than its parent
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0) {
                E temp = list.get(currentIndex);//sets variable of current to temp variable
                list.set(currentIndex, list.get(parentIndex));//takes the parent index value and puts in in current index
                list.set(parentIndex, temp);// takes temp variable and puts in it parent index
            } else {
                break; // The tree is a heap now
            }
            currentIndex = parentIndex;
        }
    }

    public E remove() {
        if (list.size() == 0) return null;
        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        int currentIndex = 0;
        while (currentIndex < list.size()) {

            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            // Find the minimum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int minIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(minIndex).compareTo(list.get(rightChildIndex)) > 0) {//if left child is bigger make minIndex rightChild
                    minIndex = rightChildIndex;
                }
            }

            // Swap if the current node is greater than the minimum
            if (list.get(currentIndex).compareTo(list.get(minIndex)) > 0) {
                E temp = list.get(minIndex);
                list.set(minIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = minIndex;
            } else
                break; // The tree is a heap
        }

        return removedObject;
    }

    public int getSize() {
        return list.size();
    }
}