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
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode curr=q.remove();

            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);

            ans.add(curr.val);
        }
        Collections.sort(ans);
        int mindiff=Integer.MAX_VALUE;

        for(int i=0;i<ans.size()-1;i++){
            mindiff=Math.min(mindiff,ans.get(i+1)-ans.get(i));
        }return mindiff;
    }
}