/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> sums=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        long sum=0;

        while(!q.isEmpty()){
            
            TreeNode curr=q.remove();
            
            if(curr!=null){
                sum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            else{
                sums.add(sum);
                if(q.isEmpty()) break;
                sum=0;
                q.add(null);
                
            }
        }Collections.sort(sums,Collections.reverseOrder());

        if(k>sums.size()) return -1;
        return sums.get(k-1);
    }
}