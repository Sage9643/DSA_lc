class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int maxprod=nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int negatives=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                negatives++;
            }if(negatives==2){
                break;
            }
        }
        if(negatives>=2){
            int currprod=nums[0]*nums[1]*nums[nums.length-1];
            maxprod=Math.max(currprod,maxprod);
        }return maxprod;
    }
}