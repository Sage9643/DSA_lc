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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        Stack<Integer> sum=new Stack<>();

        ListNode temp1=l1,temp2=l2;

        while(temp1!=null){
            s1.push(temp1.val);temp1=temp1.next;
        }
        while(temp2!=null){
            s2.push(temp2.val);temp2=temp2.next;
        }int carry=0;

        while(!s1.isEmpty() && !s2.isEmpty()){
            int add=s1.pop()+s2.pop()+carry;
            sum.push(add%10);carry=add/10;
        }while(!s1.isEmpty()){
            int add=s1.pop()+carry;
            sum.push(add%10);carry=add/10;
        }while(!s2.isEmpty()){
            int add=s2.pop()+carry;
            sum.push(add%10);carry=add/10;
        }if(carry!=0)sum.push(carry);

        ListNode newlist=new ListNode(-1);
        ListNode temp=newlist;

        while(!sum.isEmpty()){
            ListNode node=new ListNode(sum.pop());
            temp.next=node;temp=temp.next;
        }temp.next=null;
        return newlist.next;
    }
}