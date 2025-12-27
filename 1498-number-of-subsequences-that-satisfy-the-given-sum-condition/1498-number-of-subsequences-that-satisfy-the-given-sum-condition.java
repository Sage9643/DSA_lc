class Solution {
    public int numSubseq(int[] nums, int target) {
        long cnt=0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(nums[i]<target){
                int idx=bs(nums,target-nums[i]);
                if(idx>=i){
                    long ways=modPow(2,idx-i);
                    cnt=((cnt+ways)%1000000007);
                }
            }
        }return (int)cnt;
    }public static long modPow(long base,long exp){
        long res=1;
        while(exp>0){
            if((exp&1)==1) res=(res*base)%1000000007;
            base=(base*base)%1000000007;
            exp>>=1;
        }
        return res;
    }
    public static int bs(int[] nums,int tar){
        int start=0,end=nums.length-1;int idx=-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]<=tar){
                idx=mid;
                start=mid+1;
            }else end=mid-1;
        }return idx;
    }
}