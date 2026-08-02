class Solution {
    public boolean stoneGame(int[] nums) {
        int tot=0;
        for(int num:nums) tot+=num;

        int dp[][]=new int[nums.length][nums.length];

        for(int d[]:dp) Arrays.fill(d,-1);

        int me=game(nums,0,nums.length-1,dp);

        return me>=(tot-me);
        
    }
    public static int game(int nums[],int start,int end,int dp[][]){
        if(start>end) return 0;

        if(dp[start][end]!=-1) return dp[start][end];

        int takef= nums[start]+Math.min(game(nums,start+1,end-1,dp),game(nums,start+2,end,dp));
        int takel= nums[end]+Math.min(game(nums,start+1,end-1,dp),game(nums,start,end-2,dp));

        return dp[start][end]=Math.max(takef,takel);
    }
}