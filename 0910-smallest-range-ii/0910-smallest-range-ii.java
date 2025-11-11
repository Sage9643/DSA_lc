class Solution {
    public int smallestRangeII(int[] nums, int k) {
        if(nums.length==1) return 0;
        Arrays.sort(nums);
        int result=nums[nums.length-1]-nums[0];

        for(int i=0;i<nums.length-1;i++){
            int max=Math.max(nums[i]+k,nums[nums.length-1]-k);
            int min=Math.min(nums[0]+k,nums[i+1]-k);
            result=Math.min(result,max-min);
        }return result;
        
    }
}