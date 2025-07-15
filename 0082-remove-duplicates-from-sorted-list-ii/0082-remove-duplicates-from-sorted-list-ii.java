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
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=new ListNode(-1);
        ListNode unique=temp;
        ListNode nodecurr=head;
        ListNode nodeprev=null;
        ListNode nodenext=head.next;
        while(nodecurr!=null){
            if(nodeprev==null){
                if(nodecurr.val!=nodenext.val){
                    temp.next=nodecurr;
                    temp=temp.next;
                }nodeprev=nodecurr;
                nodecurr=nodenext;
                nodenext=nodenext.next;
            }else if(nodenext==null){
                if(nodecurr.val!=nodeprev.val){
                    temp.next=nodecurr;
                    temp=temp.next;
                }nodeprev=nodecurr;
                nodecurr=nodenext;
            }
            else{
                if(nodecurr.val!=nodeprev.val && nodecurr.val!=nodenext.val){
                    temp.next=nodecurr;
                    temp=temp.next;
                }nodeprev=nodecurr;
                nodecurr=nodenext;
                nodenext=nodenext.next;
            }  
        }temp.next=null;
        return unique.next;
    }
}