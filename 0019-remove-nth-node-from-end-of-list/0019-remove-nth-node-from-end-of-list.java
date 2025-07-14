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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){
            return null;
        }
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }if(n==size){
            head=head.next;
            return head;
        }
        int elementidx=size-n;
        ListNode temp2=head;
        for(int i=1;i<elementidx;i++){
            temp2=temp2.next;
        }temp2.next=temp2.next.next;
        return head;
    }
}