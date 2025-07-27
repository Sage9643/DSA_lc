/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<>();
        ArrayList<TreeNode> path2=new ArrayList<>();

        getPath(root,p,path1);
        getPath(root,q,path2);

        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }return path1.get(i-1);


    }public static boolean getPath(TreeNode root,TreeNode node,ArrayList<TreeNode> path){
        if(root==null){
            return false;
        }path.add(root);

        if(root==node){
            return true;
        }
        boolean leftPath=getPath(root.left,node,path);
        boolean rightPath=getPath(root.right,node,path);

        if(leftPath || rightPath){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}