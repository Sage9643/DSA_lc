class Solution {
    static int[] par;
    static int[] rank;
    public int makeConnected(int n, int[][] connections) {
        par=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++) par[i]=i;

        int extra=0;

        for(int c[]:connections){
            int para=find(c[0]);
            int parb=find(c[1]);

            if(para==parb) extra++;

            else{
                union(c[0],c[1]);
            }
        }int comp=0;
        for(int i=0;i<n;i++){
            if(i==par[i]) comp++;
        }
        if(extra<comp-1) return -1;
        return comp-1;

    }public static int find(int x){
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
        else if(rank[para]==rank[parb]) par[para]=parb;
        else par[parb]=para;
    }
}