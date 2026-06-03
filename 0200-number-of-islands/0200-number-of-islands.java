class Solution {
    static int cnt;
    public int numIslands(char[][] grid) {
        cnt=0;
        int n=grid.length;int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid,i,j,vis);
                    cnt++;
                }
            }
        }return cnt;
    }public static void dfs(char[][] graph,int r,int c,boolean vis[][]){
        vis[r][c]=true;

        if(r>0){
            if(!vis[r-1][c] && graph[r-1][c]=='1') dfs(graph,r-1,c,vis);
        }if(c<graph[0].length-1){
            if(!vis[r][c+1] && graph[r][c+1]=='1') dfs(graph,r,c+1,vis);
        }if(c>0){
            if(!vis[r][c-1] && graph[r][c-1]=='1') dfs(graph,r,c-1,vis);
        }if(r<graph.length-1){
            if(!vis[r+1][c] && graph[r+1][c]=='1') dfs(graph,r+1,c,vis);
        }
    }
}