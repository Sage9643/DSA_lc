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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=new ListNode(-1);
        ListNode newhead=temp;
        ListNode prev=head;
        ListNode curr=head.next;
        while(curr!=null){
            temp.next=curr;
            temp=temp.next;
            prev.next=curr.next;
            temp.next=prev;
            temp=temp.next;
            prev=prev.next;
            if(prev==null){
                curr=null;
            }else{
                curr=prev.next;
            }
        }return newhead.next;

    }
}