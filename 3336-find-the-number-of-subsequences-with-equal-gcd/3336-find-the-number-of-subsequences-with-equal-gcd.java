class Solution {
    public int subsequencePairCount(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int num:nums) max=Math.max(max,num);

        int dp[][][]=new int[nums.length][max+1][max+1];
        for(int d[][]:dp){
            for(int a[]:d) Arrays.fill(a,-1);
        }

        return subsequencePairCountUtil(nums,0,0,0,dp);


    }
    public static int subsequencePairCountUtil(int nums[], int idx, int gcd1, int gcd2, int dp[][][]){
        if(idx==nums.length){
            return (gcd1!=0 && gcd2!=0 && gcd1==gcd2) ? 1:0;
        }
        if(dp[idx][gcd1][gcd2]!=-1) return dp[idx][gcd1][gcd2];

        int skip= subsequencePairCountUtil(nums, idx+1, gcd1, gcd2 ,dp);
        int set1= subsequencePairCountUtil(nums, idx+1, gcd(gcd1, nums[idx]), gcd2, dp);
        int set2= subsequencePairCountUtil(nums, idx+1, gcd1 ,gcd(gcd2,nums[idx]) , dp);

        return dp[idx][gcd1][gcd2]=(int)((0L+ skip +set1 + set2)%1000000007);
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return Math.abs(a);
    }
}