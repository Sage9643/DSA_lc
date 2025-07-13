class Solution {
    public int missingNumber(int[] nums) {
        int largest=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>largest){
                largest=nums[i];
            }
        }
        int count[]=new int[largest+1];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }for(int i=0;i<count.length;i++){
            if(count[i]==0){
                return i;
            }
        }return -1;
    }
}