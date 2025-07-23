class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return getGain(s, 'a', 'b', x, y);
        } else {
            return getGain(s, 'b', 'a', y, x);
        }
    }

    private int getGain(String s, char first, char second, int firstGain, int secondGain) {
        Stack<Character> st = new Stack<>();
        int score = 0;
        // First pass: remove higher gain pattern
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && st.peek() == first && ch == second) {
                st.pop();
                score += firstGain;
            } else {
                st.push(ch);
            }
        }

        // Convert remaining stack to string
        StringBuilder sb = new StringBuilder();
        for (char ch : st) sb.append(ch);

        // Second pass: remove the lower gain pattern
        st.clear();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (!st.isEmpty() && st.peek() == second && ch == first) {
                st.pop();
                score += secondGain;
            } else {
                st.push(ch);
            }
        }

        return score;
    }

}