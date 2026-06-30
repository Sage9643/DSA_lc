class Solution {
    public int minMoves(int[] nums) {
        if(nums.length==1) return 0;
        int min=Integer.MAX_VALUE;

        for(int num:nums) min=Math.min(min,num);
        
        int ans=0;
        for(int num:nums) ans+=num-min;

        return ans;

    }
}