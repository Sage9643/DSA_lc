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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        HashMap<TreeNode,TreeNode> map=new HashMap<>();

        dfs(root,map);

        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        HashSet<TreeNode> vis=new HashSet<>();
        vis.add(target);
        int level=0;;

        while(!q.isEmpty()){
            int size=q.size();

            if(level==k){
                for(int i=0;i<size;i++){
                    TreeNode node=q.remove();
                    ans.add(node.val);
                }break;
                
            }
            for(int i=0;i<size;i++){
                TreeNode node=q.remove();
           
                if(node.left!=null && !vis.contains(node.left)) {
                    q.add(node.left);
                    vis.add(node.left);
                }
                if(node.right!=null && !vis.contains(node.right)){
                    q.add(node.right);
                    vis.add(node.right);
                }
                if(map.containsKey(node) && !vis.contains(map.get(node))){
                    q.add(map.get(node));
                    vis.add(map.get(node));
                }
            }level++;
        }
        return ans;
    }
    public static void dfs(TreeNode root,HashMap<TreeNode,TreeNode> map){
        if(root==null) return ;

        if(root.left!=null) map.put(root.left,root);
        dfs(root.left,map);
        if(root.right!=null) map.put(root.right,root);
        dfs(root.right,map);
    }
}