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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);

        ListNode temp=new ListNode(-1);
        ListNode newHead=temp;
        ListNode next=head;
        while(next!=null){
            if(!set.contains(next.val)){
                temp.next=next;
                temp=temp.next;
            }next=next.next;
        }temp.next=null;
        return newHead.next;

    }
}