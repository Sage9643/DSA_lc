class Solution {
    static int par[],rank[];
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        par=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++) par[i]=i;

        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff) union(i-1,i);
        }
        boolean ans[]=new boolean[queries.length];
        int idx=0;

        for(int q[]:queries){
            int para=find(q[0]);
            int parb=find(q[1]);

            if(para==parb) ans[idx++]=true;
            else ans[idx++]=false;
        }
        return ans;

    }
    public static int find(int x){
        if(x==par[x]) return x;
        return x=find(par[x]);
    }
    public static void union(int a, int b){
        int para=find(a);
        int parb=find(b);

        if(para==parb) return;

        if(rank[para]==rank[parb]){
            par[parb]=para;
            rank[para]++;
        }
        else if(rank[para]<rank[parb]){
            par[para]=parb;
        }
        else par[parb]=para;
    }
}