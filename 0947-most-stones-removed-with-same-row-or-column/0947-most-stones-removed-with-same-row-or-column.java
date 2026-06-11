class Solution {
    static int par[];
    static int rank[]; 
    public int removeStones(int[][] stones) {
        int n=0;int m=0;
        HashSet<Integer> set=new HashSet<>();

        for(int s[]:stones){
            n=Math.max(n,s[0]);
            m=Math.max(m,s[1]);
        }
        par=new int[n+1+m+1];
        rank=new int[n+1+m+1];

        for(int i=0;i<par.length;i++){
            par[i]=i;
        }

        for(int s[]:stones){
            int r=s[0];
            int c=s[1]+n+1;
            set.add(r);
            set.add(c);

            int para=find(r);
            int parb=find(c);

            if(para==parb) continue;
            union(r,c);

        }int cnt=0;
        for(int node:set){
            if(node==find(node)) cnt++;
        }
        return stones.length-cnt;
    }
    public static int find(int x){
        if(x==par[x]) return x;
        return par[x]=find(par[x]);
    }
    public static void union(int a,int b){
        int para=find(a);
        int parb=find(b);

        if(rank[para]==rank[parb]){
            par[parb]=para;
            rank[para]++;
        }
        else if(rank[para]<rank[parb]) par[para]=parb;
        else par[parb]=para;

    }
}