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
    static int cnt,previdx,firstidx,mindist,maxdist,prevel;
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        cnt=1;prevel=0;
        previdx=-1;firstidx=-1;
        mindist=Integer.MAX_VALUE;maxdist=Integer.MIN_VALUE;

        solve(head);

        int ans[]={mindist,maxdist};
        if(mindist==Integer.MAX_VALUE) ans[0]=-1;
        if(maxdist==Integer.MIN_VALUE) ans[1]=-1;

        return ans;
    }
    public static void solve(ListNode head){
        if(head.next==null) return;
        
        if(cnt!=1 && ((head.val>prevel && head.val>head.next.val) || (head.val<prevel && head.val<head.next.val))){
            if(firstidx==-1){
                firstidx=cnt;    
            }else{
                mindist=Math.min(mindist,cnt-previdx);
                maxdist=Math.max(maxdist,cnt-firstidx);
            }
            previdx=cnt;
            
        }
        prevel=head.val;
        cnt=cnt+1;
        solve(head.next);

    }
}