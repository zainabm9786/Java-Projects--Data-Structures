// Name: Zainab Mohammed
// Class: CS 3305/ W01
// Term: Fall 2022
// Instructor: Sharon Perry
// Assignment: 3 – Part 1 Iterator

public class A3Part1Iterator {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insert(1);
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.insert(7);
        linkedList.removeRepetitions();
        linkedList.printRange(2, 5);
        System.out.println("");
        linkedList.printRange(2, 78);
        System.out.println("");
        linkedList.printRange(2, 1);
        System.out.println("");
        linkedList.printRange(8, 5);

    }
}

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head = null;

    public void insert(int x) {
        Node newNode = new Node(x);
        if (head == null) {//if empty
            head = newNode;
            newNode.next = null;
            newNode.prev = null;
            return;
        } else {//if there is already a node
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            if (curr == head) {
                newNode.prev = head;
                newNode.next = null;
                curr.next = newNode;
            } else {
                newNode.prev = curr;
                newNode.next = null;
                curr.next = newNode;
            }
        }
    }

    public void removeRepetitions() {
        Node curr = head, move;
        while (curr != null && curr.next != null) {
            move = curr;

            while (move.next != null) {
                if (curr.data == move.next.data) {//if there is a matching case
                    move.next = move.next.next;
                } else {
                    move = move.next;
                }
            }
            curr = curr.next;
        }
    }

    public void printRange(int x, int y) {
        Node curr = head;
        System.out.print("List: ");
        while (curr != null) {//print the numbers in the node
            System.out.print(curr.data + ", ");
            curr = curr.next;
        }
        System.out.println("");
        for (curr = head; curr != null; curr = curr.next) {
            if (x > y) {
                if (curr.data >= x) {
                    System.out.print(curr.data + " ");
                }
            }
            if (curr.data >= x && curr.data < y) {
                System.out.print(curr.data + " ");
            }
        }

    }
}
