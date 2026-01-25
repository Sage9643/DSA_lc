class Solution {
    public int minimumPrefixLength(int[] nums) {
        boolean arr[]=new boolean[nums.length];
        arr[0]=true;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]) arr[i]=true;
        }int ind=0;

        for(int i=arr.length-1;i>=0;i--){
            if(!arr[i]) {
                ind=i;
                break;}
        }return ind;

    }
}