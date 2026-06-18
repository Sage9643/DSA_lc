class Solution {
    public boolean canPartition(int[] nums) {
        int tot=0;
        for(int n:nums) tot+=n;

        if(tot%2!=0) return false;

        tot/=2;

        boolean dp[][]=new boolean[nums.length+1][tot+1];
        for(int i=0;i<dp.length;i++) dp[i][0]=true;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=nums[i-1]){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }else dp[i][j]=dp[i-1][j];
            }
        }return dp[dp.length-1][tot];
    }
}