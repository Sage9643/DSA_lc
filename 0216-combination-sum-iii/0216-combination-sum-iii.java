class Solution {
    static HashSet<List<Integer>> s;
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        s=new HashSet<>();
        HashSet<Integer> set=new HashSet<>();
        backtrack(set,n,k,0);

        List<List<Integer>>ans=new ArrayList<>(s);

        return ans;
    }
    public static void backtrack(HashSet<Integer> set,int n,int k,int sum){
        if(set.size()>k || sum>n) return;
        if(set.size()==k && sum==n){
            List<Integer> l=new ArrayList<>(set);
            s.add(l);
        }
        for(int i=1;i<=9;i++){
            if(!set.contains(i)){
                set.add(i);
                backtrack(set,n,k,sum+i);
                set.remove(i);
            }
        }
    }
}