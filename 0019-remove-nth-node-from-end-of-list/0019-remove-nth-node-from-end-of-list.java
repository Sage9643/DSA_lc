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
        
        int size=sizeOfLL(head);

        int i=size-n;
        if(i==0){
            head=head.next;
            return head;
        }
        ListNode temp=new ListNode();
        temp=head;int k=0;

        while(temp!=null & k<i-1){
            temp=temp.next;
            k++;
        }
        ListNode next=temp.next.next;

        temp.next=next;

        return head;
    }
    public static int sizeOfLL(ListNode head){
        ListNode temp=head;

        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }
}