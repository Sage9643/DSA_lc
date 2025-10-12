class Solution {
    static int count=0;

    public int findTargetSumWays(int[] nums, int target) {
        count=0;
        targetSum(nums,0,0,target);
        return count;
    }
    public static void targetSum(int nums[],int sum,int idx,int target){
        if(idx==nums.length){
            if(sum==target) count++; 
            return;
        }targetSum(nums,sum+nums[idx],idx+1,target);
        targetSum(nums,sum-nums[idx],idx+1,target);
    }
}