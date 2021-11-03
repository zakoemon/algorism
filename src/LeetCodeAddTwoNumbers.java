import java.util.Arrays;

public class LeetCodeAddTwoNumbers {
    public static void main(String args[]) {
        int[] arr = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int[] arr2 = {5,6,4};

        ListNode base1 = createListNode(arr);
        ListNode base2 = createListNode(arr2);
        ListNode ans = solution(base1, base2);
        System.out.println(ans.val);


    }
    private static ListNode createListNode(int[] arr) {
        final ListNode head = new ListNode();
        ListNode current = head;
        for (int i : arr) {
           current.val = i;
           current.next = new ListNode();
           current = current.next;
        }
        return head;
    }
    private static void show(ListNode node) {
        ListNode keep = node;
        while (keep != null) {
            System.out.println(keep.val);
            keep = keep.next;
        }
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        int countL1 = 0;
        while (l1Head.next != null) {
            countL1 ++;
            l1Head = l1Head.next;
        }
        int countL2 = 0;
        while (l2Head.next != null) {
            countL2 ++;
            l2Head = l2Head.next;
        }
        helper(l1);
        helper(l2);
        long calc1 = 0;
        while (l1Head != null) {
            calc1 = calc1 + (long)(l1Head.val * Math.pow(10, countL1));
            l1Head = l1Head.next;
            countL1--;
        }
        long calc2 = 0;
        while (l2Head != null) {
            calc2 = calc2 + (long)(l2Head.val * Math.pow(10, countL2));
            l2Head = l2Head.next;
            countL2 --;
        }

        long sum = calc1 + calc2;
        ListNode head = new ListNode();
        ListNode keep = head;
        long val = 0;
        for (int i = 10;; i *= 10) {
            val = sum % 10;
            keep.val = (int)val;
            if (sum <= 9) break;
            keep.next = new ListNode();
            keep = keep.next;
            sum = sum / 10;
        }
        return head;
    }

    private static ListNode helper(ListNode current) {
        if (current == null|| current.next == null) return current;
        ListNode first = current;
        ListNode second = helper(current.next);
        second.next = first;
        first.next = null;
        return first;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
