class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] lastSeen = new int[32];

        // Traverse from end to start
        for (int i = n - 1; i >= 0; i--) {
            // For every bit in nums[i], update last seen position
            for (int b = 0; b < 32; b++) {
                if ((nums[i] & (1 << b)) != 0) {
                    lastSeen[b] = i;
                }
            }

            // The farthest position we need to go to include all necessary bits
            int maxReach = i;
            for (int b = 0; b < 32; b++) {
                maxReach = Math.max(maxReach, lastSeen[b]);
            }

            ans[i] = maxReach - i + 1;
        }

        return ans;
    }
}
