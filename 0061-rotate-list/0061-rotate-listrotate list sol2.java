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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        //size of ll
        int size=0;
        ListNode temp1=head;
        while(temp1!=null){
            size++;
            temp1=temp1.next;
        }
        k=k%size;
        if(k==0){
            return head;
        }ListNode temp2=head;
        ListNode prev=null;
        for(int i=0;i<k;i++){
            while(temp2.next!=null){
                prev=temp2;
                temp2=temp2.next;

            }temp2.next=head;
            head=temp2;
            prev.next=null;
        }return temp2;

    }
}