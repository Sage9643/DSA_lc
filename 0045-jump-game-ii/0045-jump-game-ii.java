class Solution {
    public int jump(int[] nums) {
        long dp[]=new long[nums.length];
        dp[dp.length-1]=0;

        for(int i=dp.length-2;i>=0;i--){
            dp[i]=(long)Integer.MAX_VALUE;
            for(int j=Math.min(nums[i],dp.length-1-i);j>=0;j--) dp[i]=Math.min(dp[i],1+dp[i+j]);
        }return (int)dp[0];
    }
}