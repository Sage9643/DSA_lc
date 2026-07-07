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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<int[]>> map=new TreeMap<>();
        Queue<info> q=new LinkedList<>();

        List<List<Integer>> ans=new ArrayList<>();

        if(root==null) return ans;

        q.add(new info(root,0,0));

        while(!q.isEmpty()){
            info curr=q.remove();
            if(!map.containsKey(curr.col)) map.put(curr.col,new ArrayList<>());
            map.get(curr.col).add(new int[]{curr.node.val,curr.row});

            if(curr.node.left!=null) q.add(new info(curr.node.left,curr.col-1,curr.row+1));
            if(curr.node.right!=null) q.add(new info(curr.node.right,curr.col+1,curr.row+1));
        }
        

        for(int key:map.keySet()){
            List<int[]> arr=map.get(key);
            Collections.sort(arr,(a,b)->{
                if(a[1]==b[1]) return a[0]-b[0];
                return a[1]-b[1];
            });
            List<Integer> l=new ArrayList<>();
            for(int[] a:arr) l.add(a[0]);
            ans.add(l);
        }
        return ans;
    }
}class info{
    TreeNode node;
    int col;
    int row;

    public info(TreeNode node,int col,int row){
        this.node=node;
        this.col=col;
        this.row=row;
    }
}