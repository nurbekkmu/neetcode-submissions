# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        L, R = dummy, head
        
        for _ in range(n):
            R = R.next

        while L:
            if R == None:
                L.next = L.next.next
                break
            else:
                L = L.next
                R = R.next

        return dummy.next                
        