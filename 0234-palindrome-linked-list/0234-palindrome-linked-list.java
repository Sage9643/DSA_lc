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
        if(head==null || head.next==null){
            return true;
        }
        //step 1 finding mid
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }ListNode righthalf=slow.next;
        slow.next=null;
        //step 2 reversing right half of array
        ListNode prev=null;
        ListNode curr=righthalf;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        while(head!=null && prev!=null){
            if(head.val!=prev.val){
                return false;
            }head=head.next;
            prev=prev.next;
        }return true;
    }

}