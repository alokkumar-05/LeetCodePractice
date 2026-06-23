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
        //edge case
        if(head==null || head.next==null){
            return true;
        }

        //find middle
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev= null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow = slow.next;
            fast=fast.next.next;
        }

        //reverse second half
        ListNode revHead=reverseList(slow);
        prev.next=null;

        //compare both half
        while(revHead!=null && head!=null){
            if(revHead.val!=head.val){
                return false;
            }
            revHead=revHead.next;
            head=head.next;
        }
        return true;       
    }
    
    //recursive reverse
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }

}