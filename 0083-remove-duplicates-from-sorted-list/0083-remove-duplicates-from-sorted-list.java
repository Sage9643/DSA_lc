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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=new ListNode(-111);
        ListNode start=temp;
        while(head!=null){
            if(temp.val!=head.val){
                temp.next=head;
                temp=temp.next;
            }head=head.next;
        }temp.next=null;//at end temp should point to null,it at the end duplicates are present then temp will point to that and if add the end we dont point temp to null then it will pojnt to that duplicate and give wrong output
        return start.next;
    }
}