class Solution {
    public int divide(int dividend, int divisor) {
        // Special case: overflow. If we try to divide Integer.MIN_VALUE by -1, 
        // the result is 2147483648 which is more than Integer.MAX_VALUE (2147483647)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        } // Convert both numbers to long and take their absolute values
        // This prevents overflow for Integer.MIN_VALUE
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        int result = 0; // This will store the final quotient

        // Try all powers of 2 starting from the highest (31 down to 0)
        for (int i = 31; i >= 0; i--) {
            // Check if divisor * 2^i fits into the current dividend
            // i.e., check if (dividend >> i) >= divisor
            if ((n >> i) >= d) {
                result += 1 << i;  // Add 2^i to the result
                n -= d << i;       // Subtract (divisor * 2^i) from the dividend
            }
        }
        // Determine the sign of the result
        // If dividend and divisor have the same sign, result is positive
        // Otherwise, result is negative
        return (dividend > 0) == (divisor > 0) ? result : -result;
    }
}
