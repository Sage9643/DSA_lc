class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int flight[]:flights){
            graph[flight[0]].add(new int[]{flight[1],flight[2]});
        }

        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            if(i!=src) dist[i]=Integer.MAX_VALUE;
        }

        Queue<info> q=new LinkedList<>();
        q.add(new info(src,0,0));

        while(!q.isEmpty()){
            info curr=q.remove();
            if(curr.stops>k) break;

            for(int i=0;i<graph[curr.v].size();i++){
                if(curr.cost+graph[curr.v].get(i)[1]<dist[graph[curr.v].get(i)[0]] && curr.stops<=k){
                    dist[graph[curr.v].get(i)[0]]=curr.cost+graph[curr.v].get(i)[1];
                    q.add(new info(graph[curr.v].get(i)[0],curr.cost+graph[curr.v].get(i)[1],curr.stops+1));
                }
            }
        }if(dist[dst]==Integer.MAX_VALUE) return -1;
        return dist[dst];
    }
}class info{
    int v;
    int cost;
    int stops;
    info(int v,int cost,int stops){
        this.v=v;
        this.cost=cost;
        this.stops=stops;
    }
}