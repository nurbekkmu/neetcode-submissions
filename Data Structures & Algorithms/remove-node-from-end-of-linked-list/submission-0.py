class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        N = 0
        dummy = ListNode(0, head)
        curr = head
        while curr:
            N += 1
            curr = curr.next

        # Remove N - n from the linked list
        cnt = 0
        curr = dummy
        while curr.next:
            if cnt == (N - n):
                curr.next = curr.next.next
                break
            else:
                curr = curr.next
            cnt += 1

        return dummy.next