class Solution {
    public int[] singleNumber(int[] nums) {
        int arr[]=new int[2];
        int bucket1=0;//contains all the numbers containing 0 on rightmost bit
        int bucket2=0;//contains all the numbers containing 1 on rightmost bit
        long xor=nums[0];
        for(int i=1;i<nums.length;i++){
            xor^=nums[i];
        }xor=(xor & (xor-1)) ^ xor;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & xor)==0){
                bucket1^=nums[i];
            }else{
                bucket2^=nums[i];
            }
        }arr[0]=bucket1;arr[1]=bucket2;
        return arr;
    }
}