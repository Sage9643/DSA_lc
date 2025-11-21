class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int MAX = 1000;
        int[] diff = new int[MAX + 2];

        for (int[] t : trips) {
            int num = t[0];
            int start = t[1];
            int end = t[2];
            diff[start] += num;
            diff[end] -= num;
        }

        int curr = 0;
        for (int i = 0; i <= MAX; i++) {
            curr += diff[i];
            if (curr > capacity) return false;
        }
        return true;
    }
}
