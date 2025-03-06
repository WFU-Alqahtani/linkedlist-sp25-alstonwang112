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
        // At the start of the while-loop, Nodes prev and curr are both the head.

        while (curr != null) {
            if (curr.data == x) { // Checks if the integer stored in curr matches x.
                if (curr == head) { // Special case of deleting the head.
                    head = head.next; // Reassigns the Node after the current head as the new head.
                } else {
                    prev.next = curr.next; // Reassigns the previous Node's reference to the next Node.
                    curr.next = null; // Gets rid of the current Node.
                }
                break; // Exits the loop once
            } // If the integer stored in curr doesn't match x, we move on.
            prev = curr; // The next loop's prev will be this loop's curr.
            curr = curr.next; // The next loop's curr will be this loop's curr.next.
        } // Deletes x of the user's choice.


        head = head.next; // Deletes the head.

        curr = head;
        while (curr.next != null) {
            if (curr.next.next == null) {
                curr.next = null;
                break;
            }
            curr = curr.next;
        } // Deletes the last Node.

        curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } // Prints out the content of the LinkedList.

        System.out.println();

        head = new Node(20, head);
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
        while (curr != null && count < 3) {
            if (count == 2) {
                curr.next = new Node(60, curr.next);
                break;
            }
            curr = curr.next;
            count++;
        } // Inserts Node with item 60 as the fourth Node.
    }

}