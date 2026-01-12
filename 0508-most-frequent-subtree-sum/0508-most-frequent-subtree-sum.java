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
    static HashMap<Integer,Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        map=new HashMap<>();
        dfs(root);
        int maxfreq=0;
        for(int v:map.values()) maxfreq=Math.max(maxfreq,v);

        ArrayList<Integer> arr=new ArrayList<>();
        for(int k:map.keySet()){
            if(map.get(k)==maxfreq) arr.add(k);
        }
        int ans[]=new int[arr.size()];
        int idx=0;
        for(int a:arr)ans[idx++]=a; 
        
        return ans;
    }
    public static int dfs(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        int rsum=dfs(root.right);
        int lsum=dfs(root.left);

        if(rsum!=Integer.MIN_VALUE && lsum!=Integer.MIN_VALUE) map.put(lsum+rsum+root.val,map.getOrDefault(lsum+rsum+root.val,0)+1);
        else if(rsum==Integer.MIN_VALUE && lsum==Integer.MIN_VALUE) map.put(root.val,map.getOrDefault(root.val,0)+1);
        else if(lsum==Integer.MIN_VALUE) map.put(rsum+root.val,map.getOrDefault(rsum+root.val,0)+1);

        else if(rsum==Integer.MIN_VALUE) map.put(lsum+root.val,map.getOrDefault(lsum+root.val,0)+1);

        if(rsum==Integer.MIN_VALUE && lsum==Integer.MIN_VALUE) return root.val;
        else if(rsum==Integer.MIN_VALUE) return root.val+lsum;
        else if(lsum==Integer.MIN_VALUE) return root.val+rsum; 
        return root.val+rsum+lsum; 

        
    }
}