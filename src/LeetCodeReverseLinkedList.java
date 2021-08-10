//https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/2378/

import java.util.List;

class LeetCodeReverseLinkedList {

    public static void main(String args[]) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        if (current == null) return head;
        while (current.next != null) {
            current = current.next;
        }
        helper(head);
        return current;
    }

    public static ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = helper(head.next);
        ListNode first = head;
        ListNode keep = second;
        first.next = null;
        keep.next = first;
        return first;
    }

    public static ListNode otherSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // p is gonna be always the last node
        ListNode p = otherSolution(head.next);
        /*
        1 -> 2 -> 3 -> 4
        when head is 3
        4 -> 3 -> null *2 still has reference to 3
         */
        head.next.next = head;
        head.next = null;
        // it's always 4 if it's like the ex
        return p;
    }

    public static class ListNode {
        int val;
        ListNode next;
    }
}