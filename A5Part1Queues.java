// Name: Zainab Mohammed
// Assignment: 05-Part-1-Queues

import java.util.*;
import java.util.LinkedList;

class A5QueuesPart1 {
    static LinkedList<String> linkedList = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//uses a priority queue to store a list of chores and the chore’s
//priority. You need to store the name of the chore and it’s assigned priority.
// Assigned priorities can
//be any positive integer. The rest is up to you.
        //last index means highest prority

        LinkedList<Chores> stringQueue = new LinkedList<PriorityQueue>();

        int count = 0;
        while (true) {
            if (count > 0) {
                sc.nextLine();
            }
            System.out.println("Please enter chore name: ");
            String chore = sc.nextLine();
            System.out.println("Please enter priority: ");
            int x = sc.nextInt();
            stringQueue.add(new Chores(x, chore));//adds to chores class
            linkedList.add(x-1, chore);
            System.out.println("To stop loop, enter Y, else enter N");
            String exit = sc.next().toLowerCase();
            if (exit.equals("y")) {
                break;
            }
            count++;
        }//DO I NEED TO BE ALE TO REMOVE CHORES?
        System.out.println("Printing chores in order of Priority");
        for (int i = 0; i < stringQueue.size(); i++) {
            System.out.println((i + 1) + ") " + linkedList.get(i));
        }

    }
class Queues{
    String chore;
    int priority;
   NodeQueue back;
    NodeQueue head;
    int size;//check size of queue

    public Queues(int priority, String chore){
        this.priority=priority;
        this.chore=chore;
    }
    public void enqueue(int priority, String chore){
NodeQueue newNode=new NodeQueue(chore, priority);
if (head==null){
    back=newNode;
head=newNode;
}
else{
    back.next=newNode;

}
    }
    public void dequeue(){

    }
    public void isEmpty(){
        if (head==null){
            System.out.println("Queue is empty");
        }
        else {
            System.out.println("Queue is not empty");
        }
    }
}



class NodeQueue {
    String chore;       // chore
    int priority;//priority number
    NodeQueue next;      // pointer to the next node

    public NodeQueue(String chore, int num) {
this.priority=num;
        this.chore = chore;
        this.next = null;
    }
}

/*class Queue  {
    private static Node rear = null, front = null;
    private static int count = 0;

    // Utility function to dequeue the front element
    public static int dequeue()     // delete at the beginning
    {
        if (front == null)
        {
            System.out.println("\nQueue Underflow");
            System.exit(-1);
        }

        Node temp = front;
        System.out.printf("Removing %d\n", temp.data);

        // advance front to the next node
        front = front.next;

        // if the list becomes empty
        if (front == null) {
            rear = null;
        }

        // decrease the node's count by 1
        count -= 1;

        // return the removed item
        return temp.data;
    }*/
