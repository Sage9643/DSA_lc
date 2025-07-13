class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int currcount=1;
        int maxcount=1;
        int element=nums[0];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                currcount++;

            }else{currcount=1;}
            if(maxcount<currcount){
                maxcount=currcount;
                element=nums[i];
            }
        }return element;
    }
}