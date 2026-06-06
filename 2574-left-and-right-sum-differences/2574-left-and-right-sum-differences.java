class Solution {
    public int[] leftRightDifference(int[] nums) {
        int lsum[]=new int[nums.length];
        int rsum[]=new int[nums.length];

        lsum[0]=0;
        rsum[rsum.length-1]=0;

        for(int i=1;i<nums.length;i++){
            lsum[i]=lsum[i-1]+nums[i-1];
            rsum[rsum.length-1-i]=rsum[rsum.length-i]+nums[rsum.length-i];
        }int ans[]=new int[nums.length];
        for(int i=0;i<ans.length;i++) ans[i]=Math.abs(rsum[i]-lsum[i]);

        return ans;
    }
}