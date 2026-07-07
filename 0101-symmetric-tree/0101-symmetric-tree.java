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
    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> right=new ArrayList<>();
        dfsRight(root,right);
        ArrayList<Integer> left=new ArrayList<>();
        dfsLeft(root,left);

        for(int i=0;i<left.size();i++){
            if(left.get(i)!=right.get(i)) return false;
        }
        return true;
    }
    public static void dfsRight(TreeNode root,ArrayList<Integer> arr){
        if(root==null){
            arr.add(-1);
            return;
        }
        arr.add(root.val);

        dfsRight(root.right,arr);
        dfsRight(root.left,arr);
    }
    public static void dfsLeft(TreeNode root,ArrayList<Integer> arr){
        if(root==null){
            arr.add(-1);
            return;
        }
        arr.add(root.val);

        dfsLeft(root.left,arr);
        dfsLeft(root.right,arr);
    }
}