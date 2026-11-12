class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max=0;
        int i=0,j=1;
        int n=nums.length;
        
        while(j<n){
            if(nums[j]>nums[j-1]) j++;
            else{
                max=Math.max(max,j-i);
                i=j;
                j++;
            }
        }max=Math.max(j-i,max);

        i=0;j=1;

        while(j<n){
            if(nums[j]<nums[j-1]) j++;
            else{
                max=Math.max(max,j-i);
                i=j;
                j++;
            }
        }max=Math.max(j-i,max);
        return max;

    }
}