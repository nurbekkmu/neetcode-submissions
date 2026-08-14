/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeHelper(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        if (l > r) return null;

        int m = (l + r) / 2;
        ListNode n1 = mergeHelper(lists, l, m);
        ListNode n2 = mergeHelper(lists, m + 1, r);

        return mergeTwoLists(n1, n2);
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        current.next = (node1 != null) ? node1 : node2;
        return dummy.next;
    }
}
