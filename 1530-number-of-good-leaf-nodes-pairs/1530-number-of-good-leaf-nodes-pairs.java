class Solution {
    static int count;
    public int countPairs(TreeNode root, int distance) {
        count=0;
        dfs(root,distance);
        return count;
    }
    public static List<Integer> dfs(TreeNode node, int distance){
        if (node==null) return new ArrayList<>();

        if (node.left==null && node.right==null){
            List<Integer> leaves=new ArrayList<>();
            leaves.add(1); 
            return leaves;
        }
        List<Integer> lDist=dfs(node.left,distance);
        List<Integer> rDist=dfs(node.right,distance);

        for (int l:lDist){
            for(int r:rDist){
                if(l+r<=distance) count++;
            }
        }
        List<Integer> currDist=new ArrayList<>();
         
        for(int l:lDist){
            if(l+1<distance) currDist.add(l+1);
        }
        for(int r:rDist){
            if(r+1<distance) currDist.add(r+1);
        }
        return currDist;
    }
}