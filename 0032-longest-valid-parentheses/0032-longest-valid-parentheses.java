class Solution {
    public int longestValidParentheses(String s) {
    int Open = 0;
    int Close = 0;  // added to balance parentheses
    int MaxCount = 0;
    int CurrentCount;

    // First pass: Left to Right
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            Open++;
        } else {
            Close++;
        }

        if (Open == Close) {
            CurrentCount = 2 * Close;
            MaxCount = Math.max(MaxCount, CurrentCount);
        } else if (Close > Open) {
            Open = Close = 0;
        }
    }

    // Reset variables for second pass
    Open = Close = 0;

    // Second pass: Right to Left
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '(') {
            Open++;
        } else {
            Close++;
        }

        if (Open == Close) {
            CurrentCount = 2 * Open;
            MaxCount = Math.max(MaxCount, CurrentCount);
        } else if (Open > Close) {
            Open = Close = 0;
        }
    }

    return MaxCount;
}

}