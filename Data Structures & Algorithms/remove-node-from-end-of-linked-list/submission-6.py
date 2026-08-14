# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        d = ListNode(0, head)
        L, R = d, head        
        for _ in range(n): R = R.next
        while R: L, R = L.next, R.next
        L.next = L.next.next
        return d.next                
        