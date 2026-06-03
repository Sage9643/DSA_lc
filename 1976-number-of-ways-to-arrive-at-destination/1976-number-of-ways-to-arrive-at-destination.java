class Solution {
    public int countPaths(int n, int[][] roads) {
    
        ArrayList<int[]> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int r[]:roads){
            graph[r[0]].add(new int[]{r[1],r[2]});
            graph[r[1]].add(new int[]{r[0],r[2]});
        }
        long dist[]=new long[n];
        long ways[]=new long[n];
        ways[0]=1;

        for(int i=1;i<n;i++) dist[i]=Long.MAX_VALUE;

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long c[]=pq.remove();
            long curr=c[0];
            long d=c[1];

            for(int i=0;i<graph[(int)curr].size();i++){
                int neigh[]=graph[(int)curr].get(i);
                int v=neigh[0];
                int wt=neigh[1];
                
                if(dist[v]>d+wt){
                    dist[v]=d+wt;
                    pq.add(new long[]{v,dist[v]});
                    ways[v]=ways[(int)curr];
                    
                }else if(dist[v]==d+wt) ways[v]=(ways[v]+ways[(int)curr])%1000000007;
            }
        }
        return (int)(ways[n-1]%1000000007);
        
    }
}