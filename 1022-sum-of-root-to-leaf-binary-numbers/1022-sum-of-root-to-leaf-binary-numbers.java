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
    static ArrayList<String> nums;
    public int sumRootToLeaf(TreeNode root) {
        nums=new ArrayList<>();
        dfs(root,new StringBuilder());

        int ans=0;

        for(String s:nums){
            System.out.println(s);
            ans+=bintoint(s);
        }return ans;   
    }
    public static void dfs(TreeNode root,StringBuilder sb){
        if(root==null) return;
        
        else if(root.right==null && root.left==null){
            StringBuilder num=new StringBuilder(sb);
            num.append(Integer.toString(root.val));
            nums.add(num.toString());
            return;
        }
        sb.append(Integer.toString(root.val));
        dfs(root.left,sb);
        dfs(root.right,sb);
        sb.deleteCharAt(sb.length()-1);
    }
    public static int bintoint(String s){
        int num=0;
        int pow=s.length()-1;
        for(char ch:s.toCharArray()){
            num+=ch=='1'?((int)Math.pow(2,pow)):0;
            pow--;
        }return num;
    }
}