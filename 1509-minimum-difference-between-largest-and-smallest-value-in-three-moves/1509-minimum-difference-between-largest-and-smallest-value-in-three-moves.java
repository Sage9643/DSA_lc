class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=4) return 0;
        int mindiff=Integer.MAX_VALUE;
        Arrays.sort(nums);

        //changed 0 element of first group and 3 elements of last group of three;
        mindiff=Math.min(mindiff,nums[nums.length-4]-nums[0]); 

        //changed 1 element of first group and 2 elements of last group of three;
        mindiff=Math.min(mindiff,nums[nums.length-3]-nums[1]); 

        //changed 2 element of first group and 1 elements of last group of three;
        mindiff=Math.min(mindiff,nums[nums.length-2]-nums[2]); 

        //changed 3 element of first group and 0 elements of last group of three;
        mindiff=Math.min(mindiff,nums[nums.length-1]-nums[3]); 

        return mindiff;    
    }
}