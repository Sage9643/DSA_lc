class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        long sum=0;
        for(int num:nums) sum+=num;
        long start=1,end=sum;
        int ans=1;

        while(start<=end){
            long mid=(start+end)/2;

            if(dsum(nums,mid)>threshold) start=mid+1;
            else{
                ans=(int)mid;
                end=mid-1;
            }
        }
        return ans;
    }public long dsum(int[] nums,long d){
        long sum=0;
        for(int num:nums) sum+=Math.ceil((double)num/d);
        return sum;
    }
}