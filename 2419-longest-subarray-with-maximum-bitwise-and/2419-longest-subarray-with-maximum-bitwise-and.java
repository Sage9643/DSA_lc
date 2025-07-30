class Solution {
    public int longestSubarray(int[] nums) {
        int maxAND=0;
        for(int i=0;i<nums.length;i++){
            maxAND=Math.max(maxAND,nums[i]);
        }
        int currcount=1,maxcount=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxAND){
                int j=i+1;
                while(j<nums.length && nums[i]==nums[j]){
                    currcount++;
                    j++;
                }maxcount=Math.max(currcount,maxcount);
                i=i+currcount-1;
                currcount=1;
            }
        }return maxcount;
    }
}