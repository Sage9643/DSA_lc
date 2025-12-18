class Solution {
    public int minRemoval(int[] nums, int k) {
        if(nums.length==1) return 0;
        Arrays.sort(nums);
        int max=0;
        for(int i=0;i<nums.length;i++){
            long el=1L*nums[i]*k;
            int mid=bs(nums,el);
            
            max=Math.max(max,(mid-i+1));
        }return nums.length-max;
    }public static int bs(int nums[],long el){
        int start=0;int end=nums.length-1;int idx=-1;
        while(start<=end){
            
            int mid=(start+end)/2;
            if(nums[mid]<=el){
                idx=mid;
                start=mid+1;
            }else end=mid-1;
        }return idx;
    }
}