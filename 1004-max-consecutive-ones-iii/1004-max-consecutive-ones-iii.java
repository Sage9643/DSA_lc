class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroes=0;
        int i=0,j=0;int maxlen=0;

        while(j<nums.length && i<nums.length){
            if(nums[j]==1) j++;
            else{
                if(zeroes<k){j++;zeroes++;}
                else{
                    while(zeroes>=k){
                        if(nums[i]==0) zeroes--;
                        i++;
                    }
                }
            }maxlen=Math.max(maxlen,j-i);   
        }return maxlen;
    }
}