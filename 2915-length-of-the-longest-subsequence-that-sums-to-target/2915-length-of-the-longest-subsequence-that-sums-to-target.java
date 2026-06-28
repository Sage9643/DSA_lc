class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int dp[][]=new int[nums.size()+1][target+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i], -1);
        dp[0][0]=0;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(nums.get(i-1)<=j && dp[i-1][j-nums.get(i-1)]!=-1) dp[i][j]=Math.max(dp[i-1][j],1+dp[i-1][j-nums.get(i-1)]);
                else dp[i][j]=dp[i-1][j];
            }
        }return dp[dp.length-1][dp[0].length-1];
    }
}