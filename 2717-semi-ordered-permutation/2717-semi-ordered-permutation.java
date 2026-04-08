class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int idx1=-1,idxn=-1;
        for(int i=0;i<nums.length;i++){
            if(idx1!=-1 && idxn!=-1) break;
            else if(nums[i]==1) idx1=i;
            else if(nums[i]==nums.length) idxn=i;
        }
        int swaps=(idx1-0)+(nums.length-1-idxn);
        if(idx1>idxn) swaps--;

        return swaps;
    }
}