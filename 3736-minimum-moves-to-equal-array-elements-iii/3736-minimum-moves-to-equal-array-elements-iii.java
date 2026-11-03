class Solution {
    public int minMoves(int[] nums) {
        int max=0;int m=0;
        for(int num:nums) max=Math.max(max,num);

        for(int num:nums)m+=(max-num);
        return m;
    }
}