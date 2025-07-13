class Solution {
    public int maxSubArray(int[] nums) {
       int dig=0;
       int min=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
        if (nums[i]<0){
            dig++;
            if(nums[i]>min){
                min=nums[i];
            }
        }
       }if(dig==nums.length){
            return min;
       }else{
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            if(currsum<0){
                currsum=0;
            }maxsum=Math.max(maxsum,currsum);
        }return maxsum;
       }
    }
}