class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int i=0;

        while(i<nums.length){
            while(i<nums.length && nums[i]!=0)i++;
            int j=i;
            while(j<nums.length && nums[j]==0)j++;
            long len=j-i;
            ans+=((len*(len+1))/2);
            i=j;
        }
        return ans;
    }
}