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
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode temp=new ListNode(-1);
        ListNode output=temp;
        int carry=0;
        while(temp1!=null && temp2!=null){
            ListNode sum=new ListNode();
            sum.val=temp1.val+temp2.val+carry;
            if(sum.val>9){
                sum.val=sum.val%10;
                carry=1;
            }else{
                carry=0;
            }temp.next=sum;
            temp=temp.next;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        while(temp1!=null){
            ListNode sum=new ListNode();
            sum.val=temp1.val+carry;
            if(sum.val>9){
                sum.val=sum.val%10;
                carry=1;
            }else{
                carry=0;
            }temp.next=sum;
            temp=temp.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            ListNode sum=new ListNode();
            sum.val=temp2.val+carry;
            if(sum.val>9){
                sum.val=sum.val%10;
                carry=1;
            }else{
                carry=0;
            }temp.next=sum;
            temp=temp.next;
            temp2=temp2.next;
        }if(carry>0){
            ListNode sum=new ListNode();
            sum.val=carry;
            temp.next=sum;
        }
        return output.next;
    }
}