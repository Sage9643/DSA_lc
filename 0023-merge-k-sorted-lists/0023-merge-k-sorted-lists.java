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
        if(lists.length==0) return null;
        ArrayList<ListNode> arr=new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            arr.add(lists[i]);
        }while(arr.size()>1){
            mergeSort(arr.get(0),arr.get(1),arr);
        }
        return arr.get(0);



    }private void mergeSort(ListNode head1,ListNode head2,ArrayList<ListNode> arr){
        ListNode tempHead=new ListNode(-1);
        ListNode temp=tempHead;

        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                temp.next=head1;
                head1=head1.next;
                
            }else{
                temp.next=head2;
                
                head2=head2.next;
            }temp=temp.next;
        }if(head1!=null) temp.next=head1;
        if(head2!=null) temp.next=head2;
        arr.remove(1);arr.remove(0);arr.add(tempHead.next);

    }
}