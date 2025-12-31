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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> map=new HashMap<>();
        List<TreeNode> res=new ArrayList<>();
        subtreeString(root,map,res);
        
        return res;
    }
    public static String subtreeString(TreeNode root,HashMap<String,Integer> map,List<TreeNode> res){
        if(root==null) return "N";

        String s=Integer.toString(root.val)+","+subtreeString(root.left,map,res)+";"+subtreeString(root.right,map,res);
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2) res.add(root);
        return s;
    }
}