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
    static ArrayList<ArrayList<Integer>> paths;
    public List<String> binaryTreePaths(TreeNode root) {
        paths=new ArrayList<>();
        allpaths(root,new ArrayList<Integer>());

        List<String> ans=new ArrayList<>();
        for(ArrayList<Integer> p:paths){
            StringBuilder sb=new StringBuilder();

            for(int i=0;i<p.size();i++){
                sb.append(Integer.toString(p.get(i)));
                if(i!=p.size()-1) sb.append("->");
            }ans.add(sb.toString());
        }return ans;

    }public static void allpaths(TreeNode root,ArrayList<Integer> nodes){
        if(root==null) return;
        if(root.left==null && root.right==null){
            nodes.add(root.val);
            paths.add(new ArrayList<>(nodes));
            nodes.remove(nodes.size()-1);
            return;
        }nodes.add(root.val);
        allpaths(root.left,nodes);
        allpaths(root.right,nodes);
        nodes.remove(nodes.size()-1);
        return;
    }
}