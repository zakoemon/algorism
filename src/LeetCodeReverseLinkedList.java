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

    public static class ListNode {
        int val;
        ListNode next;
    }
}