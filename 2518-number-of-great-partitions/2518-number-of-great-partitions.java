class Solution {
    static int mod=1000000007;
    public int countPartitions(int[] nums, int k){
        int dp[][]=new int[nums.length][k];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],-1);
        int not=recursion(0,0,dp,nums,k);

        int total=0;
        for(int n:nums) total=((total%mod)+(n%mod))%mod;

        if(total<2*k) return 0;

        int pos=1;
        for(int i=0;i<nums.length;i++){
            pos=((pos%mod)*2)%mod;
        }
        return (int)((pos-(2L*not)%mod+mod)%mod);
        
    }
    public static int recursion(int i,int sum,int dp[][],int nums[],int k){
        if(sum>=k) return 0;
        if(i==nums.length) return 1;

        if(dp[i][sum]!=-1) return dp[i][sum];

        return dp[i][sum]=((recursion(i+1,sum,dp,nums,k)%mod) + (recursion(i+1,sum+nums[i],dp,nums,k))%mod)%mod;
    }
}