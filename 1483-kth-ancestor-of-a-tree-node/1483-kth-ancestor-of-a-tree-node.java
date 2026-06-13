class TreeAncestor {
    static int up[][];
    public TreeAncestor(int n, int[] parent) {
        int col=(int)(Math.log(n)/Math.log(2))+1;
        up=new int[n][col];
        for(int i=0;i<n;i++) Arrays.fill(up[i],-1);

        for(int i=0;i<n;i++) up[i][0]=parent[i];

        for(int j=1;j<col;j++){
            for(int i=0;i<n;i++) if(up[i][j-1]>=0) up[i][j]=up[up[i][j-1]][j-1];
        }
    }
    public int getKthAncestor(int node, int k) {
        for(int i=0;i<up[0].length;i++){
            if((k & (1<<i))!=0) node=up[node][i];
            if(node==-1) return -1;
        }
        return node;
    }
}
/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */