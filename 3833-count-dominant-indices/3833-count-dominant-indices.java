class Solution {
    public int dominantIndices(int[] nums) {
        double sum=nums[nums.length-1];
        int cnt=0;

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>(sum/(nums.length-i-1))) cnt++;
            sum+=nums[i];

        }return cnt;
    }
}