// Name: Zainab Mohammed
// Assignment: 7-Part-1-Sorting

class A7Part1Sorting {
    static Node head;
    static Node tail;

    static void add(int data) {
        if (head == null) {//if list is empty
            head = new Node(data);//created the head to be the new Node
        } else {//is it is not empty
            Node ptr = head;
            while (ptr.next != null) {//traverses through list
                ptr = ptr.next;
            }
            ptr.next = new Node(data);//inserts the node at the end of the linked  list
        }

    }
    public static Node middleNode(Node head) {//returns middle emelemnt os linked list
        if (head==null){
            return null;
        }
        Node f = head, s = head;// creates tow pointers one that is slow and one that is fast
        //the slow pointer moves one step forward
        // the fast one moves two steps forward
        while (f.next!=null && f.next.next!=null) {
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    static Node sort(Node leftSide, Node rightSide){//sorts the lists
        if(rightSide==null){//
            return leftSide;
        }
        if(leftSide==null){
            return rightSide;
        }
        Node temp=null;
        if(leftSide.data>=rightSide.data){//checks if the rightSide int is smaller than the right side
            temp=rightSide;
            temp.next= sort(leftSide, rightSide.next);//gets the next node
        }
        else{//checks is leftSide int is smaller tha  the rightSide
            temp=leftSide;
            temp.next= sort(leftSide.next, rightSide);//gets the next node
        }
        return temp;

    }

    private static Node mergesort(Node head) {//merges list togetherh
        if (head==null|| head.next==null){
            return head;
        }
        Node firsthalf=middleNode(head);//has the first half of the list
        Node secondHalf=firsthalf.next;//has the second half of the list
        firsthalf.next=null;// once the first half list has its
        // elemnts it makes the next null so it is not attached to the first list
        Node leftSide=mergesort(head);//uses recursion to call
        Node rightSide=mergesort(secondHalf);

        return sort(leftSide,rightSide);//return the original list completelty sorted and in 1 list
    }

    public static void printList(Node head) {//print the list
        if (head == null) {// print list of head node
            return;
        }
        printList(head.next);
        System.out.print(head.data+" ");


        Node ptr=head;
        while (ptr!=null){
            System.out.print(ptr.data + " ");
            ptr=ptr.next;
        }
    }
    public static void main(String[] args) {
         A7Part1Sorting list = new A7Part1Sorting();
        list.add(1009);// adds data to list
        list.add(21);
        list.add(3);
        list.add(55);
        list.add(2022);
        list.add(24);
        list.add(99);
        list.add(501);
        list.add(105);
        list.add(98);
        list.add(178);
        list.add(245);
        list.add(0);
        list.add(3305);
        list.add(990);
        list.add(76);
        list.add(373);
        list.add(1010);
        list.add(642);
        list.add(777);
        System.out.println("Original list is :");
        list.printList(head);
        System.out.println("\n\nSorting linked list with merge sort: ");
        list.head=mergesort(list.head);
        list.printList(head);
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next=null;
    }
}
