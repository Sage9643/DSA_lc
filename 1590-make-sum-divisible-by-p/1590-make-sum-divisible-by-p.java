class Solution {
    public int minSubarray(int[] nums, int p) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int minlen=Integer.MAX_VALUE;
        int currsum=0,totsum=0;
        map.put(0,-1);

        for(int num:nums) totsum=(totsum+num)%p;
        int target=totsum;
        if(totsum%p==0) return 0;

        for(int i=0;i<nums.length;i++){
            currsum=(currsum+nums[i])%p;
            if(map.containsKey((currsum-target+p)%p)){
                minlen=Math.min(minlen,i-map.get((currsum-target+p)%p));
            }map.put(currsum,i);
        }if(minlen==Integer.MAX_VALUE || minlen==nums.length) return -1;
        return minlen;
    }
}