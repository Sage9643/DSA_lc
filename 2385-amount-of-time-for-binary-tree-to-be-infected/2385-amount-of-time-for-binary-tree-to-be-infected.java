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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        HashSet<TreeNode> vis=new HashSet<>();
        map.put(root,null);

        dfs(root,map); 

        Queue<TreeNode> q=new LinkedList<>();
        TreeNode s=new TreeNode();

        for(TreeNode key:map.keySet()){
            if(key.val==start){
                s=key;
                break;
            }
        }
        q.add(s);
        vis.add(s);

        int mins=-1;

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode node=q.remove();
                if(node==null) continue;
                if(node.left!=null && !vis.contains(node.left)){
                    q.add(node.left);
                    vis.add(node.left);
                }
                if(node.right!=null && !vis.contains(node.right)){
                    q.add(node.right);
                    vis.add(node.right);
                }TreeNode par=map.get(node);
                if(par!=null && !vis.contains(par)){
                    q.add(map.get(node));
                    vis.add(map.get(node));
                }
                
            }mins++;
        }
        return mins;
    }
    public static void dfs(TreeNode root,HashMap<TreeNode,TreeNode> map){
        if(root==null) return;

        if(root.left!=null) map.put(root.left,root);
        dfs(root.left,map);

        if(root.right!=null) map.put(root.right,root);
        dfs(root.right,map);

    }
}