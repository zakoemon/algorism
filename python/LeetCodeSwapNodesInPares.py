# https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/



class ListNode:
    def __init__(self, val=0, next=None) -> None:
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head):
        if not head or not head.next:
            return head

        current = head
        next = head.next
        next_next = next.next
        next.next = current
        current.next = None
        current.next = self.swapPairs(next_next)
        return next
        
        

