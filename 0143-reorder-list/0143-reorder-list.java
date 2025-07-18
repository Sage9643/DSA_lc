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
    public void reorderList(ListNode head) {
        //finding mid of ll
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }ListNode mid=slow;
        Stack<ListNode> s=new Stack<>();
        while(mid!=null){
            s.push(mid);
            mid=mid.next;            
        }
        ListNode ll=head;
        ListNode nextll;
        while(!s.isEmpty() && ll!=slow && head!=null && head.next!=null){
                nextll=ll.next;
                ll.next=s.pop();
                ll=ll.next;
                ll.next=nextll;
                ll=ll.next;
            
        }if(!s.isEmpty()){
            ll.next=s.pop();
            ll=ll.next;
        }ll.next=null;

    }
}