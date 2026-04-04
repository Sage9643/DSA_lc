class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);
        int arr[]=new int[set.size()];

        int idx=0;
        for(int k:set) arr[idx++]=k;

        Arrays.sort(arr);

        int dp[][]=new int[nums.length+1][arr.length+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0) dp[i][j]=0;
                else if(nums[i-1]==arr[j-1]) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }return dp[dp.length-1][dp[0].length-1];
    }
}