class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];

        Arrays.fill(dp,-1);

        return memo(arr,0,n,dp,k);
    }
    public static int memo(int arr[],int idx,int n,int dp[],int k){
        if(idx==n) return 0;

        if(dp[idx]!=-1) return dp[idx];
        
        int maxel=arr[idx];
        int maxsum=Integer.MIN_VALUE;

        for(int j=idx;j<idx+k && j<n;j++){
            maxel=Math.max(maxel,arr[j]);
            int sum=(maxel*(j-idx+1))+memo(arr,j+1,n,dp,k);
            maxsum=Math.max(maxsum,sum);
        }
        return dp[idx]=maxsum;
    }
}