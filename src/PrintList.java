// Template for printing the linked list with forward arrows

public class PrintList {
    public static void printListWithForwardArrow(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            } else{
                // if this is the last node, print null at the end
                System.out.print(" → null \n ");
            }
        }
    }
}