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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap=new PriorityQueue<>((head1,head2)-> head1.val-head2.val);
        for(ListNode l:lists){
            if(l!=null) heap.add(l);
        }
        ListNode head=null,tail=null;
        while(!heap.isEmpty()){
            ListNode node=heap.remove();

            if(head==null) head=tail=node;
            else{
                tail.next=node;
                tail=tail.next;
            }
            if(node.next!=null) heap.add(node.next);
        }return head;
    }
}