class Solution {
    static int up[][];
    static ArrayList<Integer> graph[];
    static int col;
    static int depth[];
    static int mod=1000000007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        makeGraph(edges);
        int ver=graph.length;
        depth=new int[ver];
        col=(int)(Math.log(ver)/Math.log(2))+1;

        up=new int[ver][col];
        for(int i=0;i<graph.length;i++) Arrays.fill(up[i],-1);

        bfs();

        for(int j=1;j<col;j++){
            for(int i=1;i<graph.length;i++){
                if(up[i][j-1]>-1) up[i][j]=up[up[i][j-1]][j-1];
            }
        }
        int maxDepth=ver;

        long[] pow=new long[maxDepth+1];
        pow[0]=1;

        for(int i=1;i<=maxDepth;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }

        int ans[]=new int[queries.length];
        int idx=0;
        
        for(int q[]:queries){
            int u=q[0];
            int v=q[1];

            int d1=depth[u];
            int d2=depth[v];

            int lca=lca(u,v);
            int len=d1+d2-(2*depth[lca]);

            if(len==0) ans[idx++]=0;
            else ans[idx++]=(int)pow[len-1];
        }
        return ans;    
    }

    public static void makeGraph(int edges[][]){
        int v=edges.length+1;
        
        graph=new ArrayList[v+1];
        for(int i=0;i<=v;i++) graph[i]=new ArrayList<>();

        for(int e[]:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
    }
    public static void par(int edges[][]){
        up=new int[graph.length][col];
        for(int i=0;i<graph.length;i++) Arrays.fill(up[i],-1);
        for(int e[]:edges) up[e[1]][0]=e[0];

        for(int j=1;j<col;j++){
            for(int i=0;i<graph.length;i++){
                if(up[i][j-1]>-1) up[i][j]=up[up[i][j-1]][j-1];
            }
        }
    }
    public static void bfs(){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];

        q.add(1);
        vis[1]=true;
        depth[1]=0;
        up[1][0]=-1;

        while(!q.isEmpty()){
            int c=q.remove();

            for(int i=0;i<graph[c].size();i++){
                int neigh=graph[c].get(i);
                if(!vis[neigh]){
                    vis[neigh]=true;
                    depth[neigh]=depth[c]+1;
                    up[neigh][0]=c;
                    q.add(neigh);
                }
            }
        }
    }public static int KthAncestor(int n,int k){
        for(int j=0;j<col;j++){
            if((k & (1<<j))!=0) n=up[n][j];
            if(n==-1) return -1;
        }
        return n;
    }
    public static int lca(int u,int v){
        if(depth[u]<depth[v]){
            int temp=u;
            u=v;
            v=temp;
        }
        u=KthAncestor(u,depth[u]-depth[v]);
        if(u==v) return u;

        for(int j=col-1;j>=0;j--){
            if(up[u][j]!=up[v][j]){
                u=up[u][j];
                v=up[v][j];
            }
        }
        return up[u][0];
    }
}