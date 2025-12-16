class Solution {
    public int longestSubsequence(int[] nums) {
        int len=0;int z=0;
        int xor=0;
        for(int num:nums){
            xor^=num;
            if(num==0)z++;
            len++;
        }if(z==nums.length) return 0;
        if(xor==0) return len-1;
        return len;
    }
}