class Solution {
    public int firstMissingPositive(int[] nums) {
        int pos=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && nums[i]<=nums.length){
                pos=nums[i];
                break;
            }
        }if(pos==-1) return 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0 || nums[i]>nums.length) nums[i]=pos;
        }
        for(int i=0;i<nums.length;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]<0) continue;
            else nums[idx]=(-1)*nums[idx];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) return i+1;
        }
        return nums.length+1;
    }
}