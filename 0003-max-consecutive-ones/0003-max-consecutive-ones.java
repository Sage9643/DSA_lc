class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int ones=0;
        for(int num:nums){
            if(num==0){
                max=Math.max(max,ones);
                ones=0;
            }else ones++;
        }max=Math.max(max,ones);
        return max;
    }
}