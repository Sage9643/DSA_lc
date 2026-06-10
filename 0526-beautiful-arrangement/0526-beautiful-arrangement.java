class Solution {
    static int cnt;
    static HashSet<Integer> set;

    public int countArrangement(int n) {
        cnt=0;
        set=new HashSet<>();

        backtrack(n,1);
        return cnt;

    }public static void backtrack(int n,int idx){
        if(idx==n+1){
            cnt++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                if((i%idx)==0 || (idx%i)==0){
                    set.add(i);
                    backtrack(n,idx+1);
                    set.remove(i);
                }
            }
        }
    }
}