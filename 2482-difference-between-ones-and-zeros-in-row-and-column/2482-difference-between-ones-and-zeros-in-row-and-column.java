class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int row[]=new int[m];
        int col[]=new int[n];

        for(int i=0;i<m;i++){
            int o=0,z=0;
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) z++;
                else o++;
            }row[i]=o-z;
        }for(int i=0;i<n;i++){
            int o=0,z=0;
            for(int j=0;j<m;j++){
                if(grid[j][i]==0) z++;
                else o++;
            }col[i]=o-z;
        }
        int ans[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) ans[i][j]=row[i]+col[j];
        }
        return ans;
    }
}