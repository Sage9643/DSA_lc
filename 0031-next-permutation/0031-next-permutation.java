class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1;
        for(int i=nums.length-2;i>=0;i--){//searching the breaking point
            if(nums[i]<nums[i+1]){
                idx=i;
                break;}
        }if(idx==-1){//if array sorted in descending order/on last permutation ,then reverse the array
            for(int i=0;i<nums.length/2;i++){
                nums[i]=nums[i]^nums[nums.length-i-1];
                nums[nums.length-i-1]=nums[i]^nums[nums.length-i-1];
                nums[i]=nums[i]^nums[nums.length-i-1];
            }
        }else{//find the elent that is just greater than the element at breaking point index and swap them
            for(int i=nums.length-1;i>idx;i--){
                if(nums[i]>nums[idx]){
                    nums[i]=nums[i]^nums[idx];
                    nums[idx]=nums[i]^nums[idx];
                    nums[i]=nums[i]^nums[idx];
                    break;  }
            }
        }if(idx!=-1){//now we reverse the remaining elements from breaking idx
            for(int i=idx+1;i<idx+1+(nums.length-idx-1)/2;i++){//here limit till mid element=si+(ei-si)/2
                nums[i]=nums[i]^nums[nums.length-1-i+idx+1];
                nums[nums.length-1-i+idx+1]=nums[i]^nums[nums.length-1-i+idx+1];
                nums[i]=nums[i]^nums[nums.length-1-i+idx+1];}}
    }
}