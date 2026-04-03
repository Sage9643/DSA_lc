class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0) dp[i][j]=1;
                else if(i==0) continue;
                else if(coins[i-1]<=j) dp[i][j]+=dp[i-1][j]+dp[i][j-coins[i-1]];
                else dp[i][j]+=dp[i-1][j];
            }
        }return dp[dp.length-1][dp[0].length-1];
    }
}