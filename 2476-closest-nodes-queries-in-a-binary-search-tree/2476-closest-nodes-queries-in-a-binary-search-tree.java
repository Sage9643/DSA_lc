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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();

        inorder(root,l);

        for(int q:queries){
            int min=bsearchmin(l,q);
            int max=bsearchmax(l,q);

            List<Integer> arr=new ArrayList<>();
            
            arr.add(min);
            arr.add(max);

            ans.add(arr);

        }return ans;
    }
    public static int bsearchmin(ArrayList<Integer> arr,int val){
        int start=0,end=arr.size()-1;
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(arr.get(mid)<=val){
                ans=mid;
                start=mid+1;
            }
            else end=mid-1;
        }if(ans==-1) return -1;
        return arr.get(ans);
    }
    public static int bsearchmax(ArrayList<Integer> arr,int val){
        int start=0,end=arr.size()-1;
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(arr.get(mid)>=val){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        if(ans==-1) return -1;
        return arr.get(ans);
    }
    public static void inorder(TreeNode root,ArrayList<Integer> l){
        if(root==null) return;

        inorder(root.left,l);
        l.add(root.val);
        inorder(root.right,l);
    }
}