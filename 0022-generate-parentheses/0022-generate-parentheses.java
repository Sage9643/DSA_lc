class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(Collections.singletonList(""));
        for (int i = 1; i <= n; i++) {
            List<String> currentList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String left : dp.get(j)) {
                    for (String right : dp.get(i - 1 - j)) {
                        currentList.add("(" + left + ")" + right);
                    }
                }
            }
            dp.add(currentList);
        }
        return dp.get(n);
    }
}