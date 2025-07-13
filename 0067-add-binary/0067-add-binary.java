class Solution {
    public String addBinary(String a, String b) {
        // Determine the shorter and longer strings
        String min = a.length() > b.length() ? b : a;
        String max = a.length() > b.length() ? a : b;

        int j = max.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        // Traverse both strings from right to left
        for (int i = min.length() - 1; i >= 0; i--, j--) {
            char ch1 = max.charAt(j);
            char ch2 = min.charAt(i);

            if (ch1 == '1' && ch2 == '1') {
                sb.append(carry == 1 ? '1' : '0');
                carry = 1;
            } else if (ch1 == '1' || ch2 == '1') {
                sb.append(carry == 1 ? '0' : '1');
                carry = carry == 1 ? 1 : 0;
            } else { // both 0
                sb.append(carry == 1 ? '1' : '0');
                carry = 0;
            }
        }

        // Process remaining digits of the longer string
        while (j >= 0) {
            char ch = max.charAt(j);
            if (ch == '1') {
                sb.append(carry == 1 ? '0' : '1');
                carry = carry == 1 ? 1 : 0;
            } else {
                sb.append(carry == 1 ? '1' : '0');
                carry = 0;
            }
            j--;
        }

        // Add final carry if present
        if (carry == 1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}
