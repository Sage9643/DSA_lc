class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxlen=1;
        int i=0,j=0;

        while(i<nums.length && j<nums.length-1){
            if(nums[j]>=nums[j+1]){
                maxlen=Math.max(maxlen,j-i+1);
                i=j+1;
            }
            j++;
        }maxlen=Math.max(maxlen,j-i+1);
        return maxlen;
    }
}