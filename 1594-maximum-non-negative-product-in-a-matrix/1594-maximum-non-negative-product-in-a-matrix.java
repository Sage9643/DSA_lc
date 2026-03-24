class Solution {
    public int maxProductPath(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        long mod=1000000007;
        long maxdp[][]=new long[n][m];
        long mindp[][]=new long[n][m];

        maxdp[0][0]=grid[0][0];
        mindp[0][0]=grid[0][0];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) continue;
                if(i==0){
                    maxdp[i][j]=grid[i][j]*maxdp[i][j-1];
                    mindp[i][j]=grid[i][j]*mindp[i][j-1];
                }
                else if(j==0){
                    maxdp[i][j]=grid[i][j]*maxdp[i-1][j];
                    mindp[i][j]=grid[i][j]*mindp[i-1][j];
                }
                else{
                    long a=maxdp[i-1][j]*grid[i][j];
                    long b=mindp[i-1][j]*grid[i][j];
                    long c=maxdp[i][j-1]*grid[i][j];
                    long d=mindp[i][j-1]*grid[i][j];
                    maxdp[i][j]=Math.max(a,Math.max(b,Math.max(c,d)));
                    mindp[i][j]=Math.min(a,Math.min(b,Math.min(c,d)));
                }
            }
        }if(maxdp[n-1][m-1]<0) return -1;
        return (int)(maxdp[n-1][m-1]%mod);
    }
}