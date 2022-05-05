class Solution:
    def reverseList(self, head):
        if not head or not head.next:
            return head
        
        ret = self.reverseList(head.next)

        head.next.next = head
        head.next = None

        return ret