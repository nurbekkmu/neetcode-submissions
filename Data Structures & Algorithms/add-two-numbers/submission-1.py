# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        def to_int(head):
            s = ""
            while head:
                s += str(head.val)
                head = head.next
            return int(s[::-1])

        n1 = to_int(l1)
        n2 = to_int(l2)
        total = n1 + n2

        s = str(total)[::-1]
        dummy = ListNode()
        cur = dummy
        for ch in s:
            cur.next = ListNode(int(ch))
            cur = cur.next
        return dummy.next                
        