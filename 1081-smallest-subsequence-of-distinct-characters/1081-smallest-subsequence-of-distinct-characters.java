class Solution {
    public String smallestSubsequence(String s) {
        int[] lastocc = new int[26];
        boolean[] vis = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
            lastocc[s.charAt(i) - 'a'] = i;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (vis[ch - 'a']) continue;

            while (sb.length() > 0 &&
                   sb.charAt(sb.length() - 1) > ch &&
                   lastocc[sb.charAt(sb.length() - 1) - 'a'] > i) {

                vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(ch);
            vis[ch - 'a'] = true;
        }

        return sb.toString();
    }
}
