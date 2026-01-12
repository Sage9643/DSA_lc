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
    static List<List<String>> ans;
    public List<List<String>> printTree(TreeNode root) {
        int height=heightOfTree(root);
        ans=new ArrayList<>();
        int cols=(int)Math.pow(2,height)-1;
        for(int i=0;i<height;i++) ans.add(new ArrayList<>());
        for(List<String> i:ans){
            for(int j=0;j<cols;j++) i.add("");

        }dfs(root,0,(cols-1)/2,height);
        return ans;

        
    }public static void dfs(TreeNode root,int row,int col,int height){
        if(root==null)return;
        ans.get(row).set(col,Integer.toString(root.val));

        dfs(root.left,row+1,col-(int)Math.pow(2,height-2-row),height);
        dfs(root.right,row+1,col+(int)Math.pow(2,height-2-row),height);
    }

    public static int heightOfTree(TreeNode root){
        if(root==null) return 0;
        int rh=heightOfTree(root.right);
        int lh=heightOfTree(root.left);
        return Math.max(rh,lh)+1;
    }
}