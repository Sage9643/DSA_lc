class Solution {
    public int[] minCost(int n, int[] prices, int[][] roads) {
        ArrayList<long[]>[] graph =new ArrayList[n];
        ArrayList<long[]>[] graphl = new ArrayList[n];

        for(int i=0;i<n;i++) {
            graph[i] =new ArrayList<>();
            graphl[i]=new ArrayList<>();
        }
        for(int r[]:roads){
            graph[r[0]].add(new long[]{r[1],r[2]});
            graph[r[1]].add(new long[]{r[0],r[2]});
            graphl[r[0]].add(new long[]{r[1],1L*r[2]*r[3]});
            graphl[r[1]].add(new long[]{r[0],1L*r[2]*r[3]});
        }

        int ans[]=new int[n];

        for (int i=0;i<n;i++) {
            long dist[]=dijkstra(i,n,graph);
            long distl[]=dijkstra(i,n,graphl);

            ans[i]=prices[i];

            for(int j=0;j<n;j++) {
                if(dist[j]>=Long.MAX_VALUE/4) continue;
                if(distl[j]>=Long.MAX_VALUE/4) continue;
                ans[i]=(int)Math.min(ans[i],prices[j]+dist[j]+distl[j]);
            }
        }
        return ans;
    }
    public static long[] dijkstra(int src,int n,ArrayList<long[]> graph[]) {
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE/2);
        dist[src]=0;

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{src,0});

        while (!pq.isEmpty()){
            long[] curr=pq.remove();
            int u=(int) curr[0];
            if (curr[1]>dist[u]) continue;

            for (int i=0;i<graph[(int)curr[0]].size();i++){
                long neigh[]=graph[(int)curr[0]].get(i);
            
                if (dist[(int)neigh[0]]>curr[1]+neigh[1]) {
                    dist[(int)neigh[0]]=curr[1]+neigh[1];
                    pq.add(new long[]{neigh[0],dist[(int)neigh[0]]});
                }
            }
        }
        return dist;
    }
}