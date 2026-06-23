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
    ListNode curr;
    public boolean solve(ListNode head){
        if(head==null){
            return true;
        }
        if(!solve(head.next)|| head.val!=curr.val){
            return false;
        }
        curr=curr.next;
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        curr =head;
        return solve(head);
    }
}