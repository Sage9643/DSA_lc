class Solution {
    public int numberOfSets(int n, int k) {
        long mod=1000000007;
        long dp[][]=new long[n][k+1];

        for(int i=0;i<n;i++)
            dp[i][0]=1;

        for(int j=1;j<=k;j++){
            long sum=0;
            for(int i=0;i<n;i++){
                if(i>0) dp[i][j]=dp[i-1][j];

                dp[i][j]=(dp[i][j]+sum)%mod;
                sum=(sum+dp[i][j-1])%mod;
            }
        }
        return (int)dp[n-1][k];
    }
}