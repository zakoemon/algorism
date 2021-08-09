//https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
public class LeetCodeSwapNodesInPairs {
    public static void main(String args[]) {

    }

    public static ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    public static ListNode helper(ListNode target) {
        if (target == null) return null;
        if (target.next == null) {
            return target;
        }

        ListNode first = target;
        ListNode second = first.next;
        first.next = helper(second.next);
        second.next = first;
        return second;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
