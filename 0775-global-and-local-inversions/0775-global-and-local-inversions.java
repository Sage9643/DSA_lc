class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int minSuffix=nums[nums.length-1];
        for(int i=nums.length-3;i>=0;i--){
            if(minSuffix<nums[i]) return false;
            minSuffix=Math.min(minSuffix,nums[i+1]);
        }return true;
    }
}