class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start=1,end=0;
        for(int num:nums) end=Math.max(num,end);

        int ans=0; 

        while(start<=end){
            int mid=start+(end-start)/2;

            if(possible(threshold,nums,mid)){
                end=mid-1;
                ans=mid;
            }else start=mid+1;
        }
        return ans;
    }
    public static boolean possible(int threshold,int nums[],int mid){
        long sum=0;

        for(int num:nums) sum+=Math.ceil((double)num/mid);

        if(sum<=threshold) return true;
        return false;
    }
}