class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length;
        int dp[][]=new int[n+1][n+1];

        Arrays.sort(satisfaction);

        for(int d[]:dp) Arrays.fill(d,-1);

        return memo(satisfaction,dp,n,0,1);
    }
    public static int memo(int arr[],int dp[][], int n,int idx,int time){
        if(idx==n) return 0;

        if(dp[idx][time]!=-1) return dp[idx][time];

        int pick=memo(arr,dp,n,idx+1,time+1) + (arr[idx]*time);
        int notpick=memo(arr,dp,n,idx+1,time);

        return dp[idx][time]=Math.max(pick,notpick);
    }
}