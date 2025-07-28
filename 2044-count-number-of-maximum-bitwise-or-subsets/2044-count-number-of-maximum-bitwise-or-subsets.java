class Solution {
    //public int countMaxOrSubsets(int[] nums) {
       /* int max=0;
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
        */

    
    int max = 0, count = 0;

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Find the maximum OR that can be achieved
        for (int num : nums) {
            max |= num;  // bitwise OR assignment
        }

        // Step 2: Start DFS
        dfs(nums, 0, 0);
        return count;
    }

    // DFS function
    void dfs(int[] nums, int index, int curr) {
        if (index == nums.length) {
            if (curr == max) count++;
            return;
        }

        // Include current element in subset
        dfs(nums, index + 1, curr | nums[index]);

        // Exclude current element from subset
        dfs(nums, index + 1, curr);
    }
}

    
