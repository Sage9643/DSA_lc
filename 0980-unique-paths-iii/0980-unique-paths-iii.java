class Solution {
    static int ways;
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean vis[][]=new boolean[n][m];

        int totsteps=n*m-1;
        int start[]=new int[2];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==-1) totsteps--;
                else if(grid[i][j]==1) {start[0]=i;start[1]=j;}
            }
        }
        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};

        ways=0;

        Path(start[0],start[1],grid,vis,totsteps,n,m,0,dr,dc);

        return ways;

        
    }public static void Path(int row,int col,int grid[][],boolean vis[][],int totsteps,int n,int m,int steps,int dr[],int dc[]){
        if(steps==totsteps){
            if(grid[row][col]==2){
                ways++;
            }
            return;
        }

        vis[row][col]=true;

        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]!=-1){
                Path(nr,nc,grid,vis,totsteps,n,m,steps+1,dr,dc);
                
            }
        }vis[row][col]=false;    
    }
}