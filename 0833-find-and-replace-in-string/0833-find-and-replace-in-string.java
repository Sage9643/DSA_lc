class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int m = indices.length;
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            list.add(new int[]{indices[i], i});
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < n) {
            boolean replaced = false;

            for (int[] pair : list) {
                int idx = pair[0];
                int arrIndex = pair[1];
                String src = sources[arrIndex];
                String tgt = targets[arrIndex];

                if (i == idx && i + src.length() <= n && s.substring(i, i + src.length()).equals(src)) {
                    sb.append(tgt);
                    i += src.length();
                    replaced = true;
                    break; 
                }
            }if (!replaced) {
                sb.append(s.charAt(i));
                i++;
            }
        }return sb.toString();
    }
}
