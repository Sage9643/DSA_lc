class Solution {
    public int minSwaps(int[] nums) {
        int ones=0;
        for(int num:nums){
            if(num==1) ones++;
        }if(ones==0) return 0;

        int i=0,j=0;
        int cnt0=0;

        for(;j<ones;j++){
            if(nums[j]==0) cnt0++;
        }
        int min=cnt0;

        for(int k=0;k<nums.length && j<nums.length;k++){
            if(nums[j]==0) cnt0++;
            if(nums[i]==0) cnt0--;

            i=(i+1)%nums.length;
            j=(j+1)%nums.length;

            min=Math.min(min,cnt0);
        }
        return min;
    }
}