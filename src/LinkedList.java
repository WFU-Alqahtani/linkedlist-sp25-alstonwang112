import java.util.*;

class Node{
    int data;
    Node next = null;

    public Node(int i){
        data = i;
    }
    public Node(int i, Node n){
        data = i;
        next = n;
    }
}
public class LinkedList {

    public static void main(String[] args) {
        Random rand = new Random();
        Node head = new Node(rand.nextInt(10));
        Node curr = head;

        for (int i = 0; i < 9; i++) {
            Node temp = new Node(rand.nextInt(10));
            curr.next = temp;
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        System.out.println();

        System.out.print("Enter the x that you would like to delete: ");
        Scanner scnr = new Scanner(System.in);
        int x = 0;
        boolean error;

        do {
            try {
                x = scnr.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.print("Invalid. Try again: ");
                error = true;
            }
        } while(error); // Retrieves valid input from the user.

        curr = head;
        Node prev = head;

        while (curr != null) {
            if (curr.data == x) {
                if (prev == head) {
                    head = head.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        } // Deletes x of the user's choice.

        curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } // Prints out the content of the LinkedList.

        System.out.println();

        /*

        head = head.next; // Deletes the head.

        curr = head;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            if (curr == null) {
                prev.next = null;
            }
        } // Deletes the last Node.

        curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } // Prints out the content of the LinkedList.

        System.out.println();

        Node temp = head;
        head.data = 20;
        head.next = temp;
        // Inserts Node with item 20 at the head.

        curr = head;
        boolean stop = false;
        while (!stop) {
            curr = curr.next;
            if (curr.next == null) {
                curr.next = new Node(40, null);
                stop = true;
            }
        } // Inserts Node with item 40 at the end.

        curr = head;
        int count = 0;
        while (curr != null && count < 4) {
            prev = curr;
            if (count == 3) {
                prev = new Node(60, curr.next);
            } else {
                curr = curr.next;
            }
            count++;
        } // Inserts Node with item 60 as the fourth Node.

        curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } // Prints out the content of the LinkedList.
         */
    }

}