# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        curr = dummy
        N = 0 

        while curr.next:
            N += 1
            curr = curr.next


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

        