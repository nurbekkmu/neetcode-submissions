class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        L = dummy
        R = head
        for i in range(n):
            R = R.next

        while L:
            if R == None:
                L.next = L.next.next
                break
            else:
                R = R.next
                L = L.next
                
        return dummy.next