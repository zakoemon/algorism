from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# wrong answer: int flood
# class Solution:
#     def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
#         l1_val = self.rec(l1, 1)
#         l2_val = self.rec(l2, 1)
#         print(f"l1_val: {str(l1_val)}")
#         print(f"l2_val: {str(l2_val)}")
#         sum = l1_val + l2_val

#         head: ListNode = ListNode()
#         lin: ListNode = head
#         div = 10
#         while sum / div > 0:
#             lin.next = ListNode(sum % div)
#             lin = lin.next
#             div = div * 10
#         return head.next

#     def rec(self, lin: Optional[ListNode], wei) -> int:
#         if lin is None:
#             return 0
        
#         print(f"lin.val = {str(lin.val)}")
#         print(f"wei = {str(wei)}")

#         return (lin.val * wei) + self.rec(lin.next, wei * 10)

#     def get_list(self, li: list[int]):
#         head = ListNode(li[0], None)
#         lin = head
#         for i in li:
#             if i == 0:
#                 continue

#             next = ListNode(i, None)
#             lin.next = next
#             lin = next

#         # sol = Solution()
#         # val = sol.rec(head, 1)
#         return head

# sol = Solution()
# sol.get_list()


# head = li
# while True:
#     if head is None:
#         break
#     print(head.val)
#     head = head.next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        l3 = ListNode()
        head = l3
        self.rec(l1, l2, head)
        return l3.next

    def rec(self, l1: Optional[ListNode], l2: Optional[ListNode], l3: ListNode, exes: int = 0) -> None:
        if l1 is None and l2 is None and exes == 0:
            return
        if l1 is None:
            l1 = ListNode()
        if l2 is None:
            l2 = ListNode()

        val = l1.val + l2.val + exes
        node = ListNode()
        l3.next = node
        if val > 9:
            node.val = val - 10
            self.rec(l1.next, l2.next, node, 1)
        else:
            node.val = val
            self.rec(l1.next, l2.next, node)
