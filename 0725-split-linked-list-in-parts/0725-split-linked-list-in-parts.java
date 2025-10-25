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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size=size(head);
        ListNode arr[]=new ListNode[k];
        int length=size/k;
        int rem=size%k;

        for(int i=0;i<k;i++) arr[i]=new ListNode();
        ListNode temp=head;

        for(int i=0;i<k;i++){
            arr[i]=temp;
            int el=length+(rem>0?1:0);
            
            for(int j=1;j<el && temp!=null;j++){
                temp=temp.next;
            }
            if(temp!=null){
                ListNode newptr=temp.next;
                temp.next=null;
                temp=newptr;
            }rem--;
        }
        return arr;
    }
    public static int size(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;temp=temp.next;
        }return count;
    }
}