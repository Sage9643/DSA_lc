class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0], minSoFar = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            
            // Swap if negative
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}
