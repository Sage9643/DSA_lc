class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int minel=Integer.MAX_VALUE,maxel=Integer.MIN_VALUE;
        int minidx=0,maxidx=0;

        for(int i=0;i<n;i++){
            if(nums[i]>maxel){
                maxel=nums[i];
                maxidx=i;
            }if(nums[i]<minel){
                minel=nums[i];
                minidx=i;
            }
        }
        return Math.min(Math.min(n-maxidx,maxidx+1)+Math.min(n-minidx,minidx+1),Math.min(Math.max(minidx+1,maxidx+1),Math.max(n-minidx,n-maxidx)));


    }
}