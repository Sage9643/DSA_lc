class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=0;
        for(;i<nums.length;i++){
            if(nums[i]==1) break;
        }
        int cnt=0;i++;

        while(i<nums.length){
            if(nums[i]==1){
                if(cnt<k) return false;
                else cnt=0;
            }else cnt++;
            i++;
        }return true;
    }
}