/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //will create a cycle then apply floyds algorithm to find common element athen destroy the cycle and return common element
        if(headA==null || headB==null){
            return null;
        }

        ListNode temp=headA;
        while(temp.next!=null){
            temp=temp.next;
        }temp.next=headB;

        ListNode intersection=intersection(headA);
        temp.next=null;
        return intersection;
    }public ListNode intersection(ListNode headA){
        ListNode slow=headA;
        ListNode fast=headA;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) break;
        }if(slow!=fast){return null;}
        slow=headA;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }return slow;
        
    }
}