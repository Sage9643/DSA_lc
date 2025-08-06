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
    public int[] nextLargerNodes(ListNode head) {
        //calculating size of LL
        ListNode temp=head;int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }

        int list[]=new int[size];
        int idx=0;
        ListNode curr=head;
        while(curr!=null){
            ListNode iterator=curr;
            while(iterator!=null && (iterator.val <= curr.val)){
                iterator=iterator.next;
            }if(iterator==null) list[idx]=0;
            else list[idx]=iterator.val;
            idx++;
            curr=curr.next;

        }return list;
    }
}