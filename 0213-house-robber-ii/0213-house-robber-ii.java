class Solution {
    public int rob(int[] nums) {
        int dp1[]=new int[nums.length];
        int dp2[]=new int[nums.length];
        if(nums.length==1) return nums[0];

        dp1[0]=0;dp1[1]=nums[0];
        dp2[0]=0;dp2[1]=nums[1];

        for(int i=2;i<dp1.length;i++){
            dp1[i]=Math.max(dp1[i-1],nums[i-1]+dp1[i-2]);
        }
        for(int i=2;i<dp2.length;i++){
            dp2[i]=Math.max(dp2[i-1],nums[i]+dp2[i-2]);
        }return Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
    }
}