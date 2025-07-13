class Solution {
    public int lastRemaining(int n) {
        return eliminate(1, 1, n, true);
    }

    private int eliminate(int head, int step, int remaining, boolean left) {
        if (remaining == 1) return head;
        if (left || remaining % 2 == 1) {
            head = head + step;
        }
        return eliminate(head, step * 2, remaining / 2, !left);
    }
}
