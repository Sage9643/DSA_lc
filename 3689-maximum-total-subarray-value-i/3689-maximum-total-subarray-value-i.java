class Solution {
    public long maxTotalValue(int[] nums, int k) {
        if (nums.length==1) return 0;
        long max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;

        for(int n:nums){
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        return (max-min)*k;
    }
}