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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode start = reverse(head, slow);
        ListNode secondHalf = (fast != null) ? slow.next : slow;
        ListNode p2 = secondHalf;

        while (start != null && p2 != null) {
            if (start.val != p2.val) {
                return false;
            }
            start = start.next;
            p2 = p2.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head, ListNode end) {
        
        ListNode curr = head;
        ListNode prev = null;

        while ( curr != end) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}