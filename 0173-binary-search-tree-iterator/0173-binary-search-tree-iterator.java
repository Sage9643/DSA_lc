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
class BSTIterator {
    static ArrayList<Integer> tree;
    static int idx;

    public BSTIterator(TreeNode root) {
        tree=new ArrayList<>();
        inorder(root);
        idx=0;
    }
    
    public int next(){
        return tree.get(idx++);
    }
    
    public boolean hasNext() {
        if(idx>tree.size()-1) return false;
        return true; 
    }

    public void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        tree.add(root.val);
        inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */