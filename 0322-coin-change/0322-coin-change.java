class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length+1][amount+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0 && i==0) dp[i][j]=0;
                else if(i==0) dp[i][j]=amount+1;
                else if(j==0) continue;
                else if(coins[i-1]<=j) dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                else dp[i][j]=dp[i-1][j];
            }
        }return dp[dp.length-1][dp[0].length-1]>amount?-1:dp[dp.length-1][dp[0].length-1];
    }
}