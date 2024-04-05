package practice.fastslowptrs;

import practice.utils.LinkedList;
import practice.utils.LinkedListNode;
import practice.utils.PrintList;

public class PalindromeLinkedList {

    public static void reverse(LinkedListNode from, LinkedListNode end) {
        LinkedListNode prev = from;
        LinkedListNode itr = null;
        if (from != null && from.next != null) {
            itr = from.next;
        }
        prev.next = null;

        while(itr != null && itr != end) {

            LinkedListNode next = null;
            if (itr != null && itr.next != null) {
                next = itr.next;
            }

            itr.next = prev;
            prev = itr;
            itr = next;
        }
        if (itr != null) {
            itr.next = prev;
        }
    }

    public static boolean palindrome(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        LinkedListNode end = head;
        while(fast != null) {
            if (fast != null) {
                fast = fast.next;
                end = fast != null ? fast: end;
            }
            if (fast == null) {
                break;
            }
            if (fast != null) {
                fast = fast.next;
                end = fast != null ? fast: end;
            }
            if (slow != null) {
                slow = slow.next;
            }
        }

        reverse(slow, fast);

        LinkedListNode beg = head;

        while(beg != null && end != null && beg != slow) {
            if (beg.data != end.data) {
                return false;
            }
            beg = beg.next;
            end = end.next;
        }

        return true;
    }

    public static void main( String args[] ) {

        int[][] input={
                {6, 1, 0, 5, 1, 6},
                {2, 4, 6, 4, 2},
                {0, 3, 5, 5, 0},
                {9, 27, 4, 4, 27, 9},
                {5, 4, 7, 9, 4, 5},
                {5, 10, 15, 20, 15, 10, 5}
        };

        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tLinked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tIs it a palindrome?  ");
            boolean result = palindrome(list.head);
            if(result){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}
