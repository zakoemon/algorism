# https://leetcode.com/problems/intersection-of-two-linked-lists/
# smart solution https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode):
        
        cur1 = headA
        cur2 = headB
        while cur1 is not cur2:
            cur1 = headB if cur2 is None else cur1.next
            cur2 = headB if cur1 is None else cur2.next
        return cur1