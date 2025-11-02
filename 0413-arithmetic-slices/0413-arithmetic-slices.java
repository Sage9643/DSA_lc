class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int diff[]=new int[nums.length-1];
        for(int i=1;i<nums.length;i++) diff[i-1]=nums[i]-nums[i-1];

        int i=0,j=0;
        int count=0;

        while(j<diff.length){
            if(diff[i]!=diff[j]){
                count+=((j-i-1)*(j-i))/2;
                i=j;
            }j++;
        }count+=((j-i-1)*(j-i))/2;
        return count;
    }
}