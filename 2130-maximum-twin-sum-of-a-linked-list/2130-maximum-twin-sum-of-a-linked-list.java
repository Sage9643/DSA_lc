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
    public int pairSum(ListNode head) {
        int n=size(head);
        int arr[]=new int[n/2];

        ListNode temp=new ListNode();
        temp=head;
        int i=0;
        int max=0;
        while(i<n/2){
            arr[i++]=temp.val;
            temp=temp.next;
        }while(i<n){
            arr[n-i-1]+=temp.val;
            max=Math.max(max,arr[n-i-1]);
            i++;
            temp=temp.next;
        }return max;

    }public static int size(ListNode head){
        ListNode temp=new ListNode();
        temp=head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }return cnt;
    }
}