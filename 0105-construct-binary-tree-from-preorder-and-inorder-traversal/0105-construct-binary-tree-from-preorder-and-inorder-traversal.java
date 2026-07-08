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
    static int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        idx=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) map.put(inorder[i],i);

        return constructBT(preorder,inorder,0,n-1,map);
    }
    public static TreeNode constructBT(int[] preorder, int[] inorder,int start,int end,HashMap<Integer,Integer> map){
        if(start>end) return null;

        TreeNode root=new TreeNode(preorder[idx]);
        idx++;
        int i=map.get(root.val);

        root.left=constructBT(preorder,inorder,start,i-1,map);
        root.right=constructBT(preorder,inorder,i+1,end,map);

        return root;
    }
}