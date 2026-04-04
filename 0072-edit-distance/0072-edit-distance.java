class Solution {
    public int minDistance(String s1, String s2) {
        int dp[][]=new int[s2.length()+1][s1.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0) dp[i][j]=j;
                else if(j==0) dp[i][j]=i;
                else if(s1.charAt(j-1)==s2.charAt(i-1)) dp[i][j]=dp[i-1][j-1];
                else{
                    int insert=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int rep=dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(insert,Math.min(del,rep));
                }
            }
        }return dp[dp.length-1][dp[0].length-1];
    }
}