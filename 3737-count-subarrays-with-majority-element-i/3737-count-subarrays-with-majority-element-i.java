class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            int cnttar=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==target) cnttar++;
                if(cnttar>(j-i+1)/2) cnt++;
            }
        }return cnt;
    }
}