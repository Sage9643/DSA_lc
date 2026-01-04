class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();

        for(int t:target) set.add(t);

        for(int i=1;i<=n;i++){
            ans.add("Push");
            if(set.contains(i)) set.remove(i);
            else ans.add("Pop");
            if(set.isEmpty()) break;
        }return ans;
    }
}