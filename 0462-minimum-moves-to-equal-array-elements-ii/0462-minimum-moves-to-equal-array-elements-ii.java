class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int el=nums[nums.length/2];

        int cnt=0;

        for(int num:nums) cnt+=Math.abs(num-el);
        return cnt;
    }
}