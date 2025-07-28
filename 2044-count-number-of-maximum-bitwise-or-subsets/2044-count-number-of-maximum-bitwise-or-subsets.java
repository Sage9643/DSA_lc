class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max|=nums[i];
        }
        int permutations=1<<nums.length;
        int count=0;

        for(int i=1;i<permutations;i++){
            int currOR=0;
        
            for(int j=0;j<nums.length;j++){
                if((i & (1<<j))!=0){
                    currOR|=nums[j];
                }
            }
            if(currOR==max){
                count++;
            }
        }return count;
    }
}