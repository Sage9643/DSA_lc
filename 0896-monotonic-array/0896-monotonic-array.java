class Solution {
    public boolean isMonotonic(int[] nums) {
        int start=nums[0];
        int end=nums[nums.length-1];
        int decider=start>=end? 0:1;
        boolean result=true;
        if(decider==0){//decreasing
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]<nums[i+1]){
                    result=false;
                }
            }
        }if(decider==1){
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                    result=false;
                }
            }    
        }return result;
    }
}