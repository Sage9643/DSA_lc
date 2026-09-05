class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int max[]=new int[n];
        int min[]=new int[n];
        max[0]=nums[0];
        min[n-1]=nums[n-1];

        for(int i=1;i<n;i++){
            min[n-1-i]=Math.min(min[n-i],nums[n-1-i]);
            max[i]=Math.max(max[i-1],nums[i]);
        }
        for(int i=0;i<n;i++){
            if((max[i]-min[i])<=k) return i;
        }
        return -1;
    }
}