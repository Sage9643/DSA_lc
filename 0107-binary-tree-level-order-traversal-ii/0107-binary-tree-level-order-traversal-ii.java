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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> arr=new ArrayList<>();

        if(root==null) return ans;

        while(!q.isEmpty()){
            TreeNode curr=q.remove();
            
            if(curr==null){
                List<Integer> l=new ArrayList<>(arr);
                ans.add(l);
                arr.clear();

                if(q.isEmpty()) break;

                q.add(null);
            }
            else{
                arr.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);

            }
        }Collections.reverse(ans);
        return ans;
        
    }
}