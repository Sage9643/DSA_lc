class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int t[]:times){
            graph[t[0]-1].add(new int[]{t[1],t[2]});
        }
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            if(i!=k-1) dist[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});

        boolean vis[]=new boolean[n];

        while(!pq.isEmpty()){
            int c[]=pq.remove();
            int curr=c[0];
            int d=c[1];

            vis[curr-1]=true;

            for(int i=0;i<graph[curr-1].size();i++){
                int neigh[]=graph[curr-1].get(i);
                if(!vis[neigh[0]-1]){
                    if(dist[neigh[0]-1]>d+neigh[1]){
                        dist[neigh[0]-1]=d+neigh[1];
                        pq.add(new int[]{neigh[0],dist[neigh[0]-1]});
                    }
                }
            }
        }int t=0;
        for(int d:dist) t=Math.max(t,d);
        if(t==Integer.MAX_VALUE) return -1;
        return t;

    }
}