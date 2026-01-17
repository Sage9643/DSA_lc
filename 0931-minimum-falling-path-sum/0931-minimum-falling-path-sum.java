class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int minsum=Integer.MAX_VALUE;
        int n=matrix.length;
        int dp[][]=new int[n][n];

        for(int el=0;el<n;el++){
            //initialising dp
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==0 && j==el) dp[i][j]=matrix[0][el];
                    else dp[i][j]=101;
                }
            }
            for(int i=1;i<n;i++){
                for(int j=0;j<n;j++){
                    if(j>0 && j<n-1) dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]))+matrix[i][j];
                    else if(j==0) dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j];
                    else dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+matrix[i][j];
                }
            }int sum=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                sum=Math.min(sum,dp[n-1][i]);
            }
            minsum=Math.min(sum,minsum);
        }return minsum;
    }
}