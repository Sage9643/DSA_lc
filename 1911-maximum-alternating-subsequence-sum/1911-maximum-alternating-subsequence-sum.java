class Solution {
    public long maxAlternatingSum(int[] nums) {
        long dp[][]=new long[nums.length][2];
        for(long d[]:dp) Arrays.fill(d,-1);
        
        return rec(nums,0,0,dp);
    }
    public static long rec(int nums[],int idx,int parity,long dp[][]){
        if(idx==nums.length) return 0;

        if(dp[idx][parity]!=-1) return dp[idx][parity];

        long pick=(parity==1?-nums[idx]:nums[idx])+rec(nums,idx+1,1-parity,dp);
        long notpick=rec(nums,idx+1,parity,dp);

        return dp[idx][parity]=Math.max(pick,notpick);

        
    }
}