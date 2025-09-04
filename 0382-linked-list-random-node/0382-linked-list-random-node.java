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
    ListNode head;
    List<Integer> nums=new ArrayList<>();
    Random rand=new Random();

    public Solution(ListNode head) {
        this.head=head;
        ListNode temp=head;

        while(temp!=null){
            nums.add(temp.val);
            temp=temp.next;
        }
    }
    
    public int getRandom() {
        int random=rand.nextInt(nums.size());

        return nums.get(random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */