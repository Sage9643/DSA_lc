class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int edge[]:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return minTimetoCollectApples(graph,0,-1,hasApple);
    }

    public static int minTimetoCollectApples(ArrayList<Integer> graph[],int curr,int par,List<Boolean> hasApple){
        int time=0;

        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);
            

            if(neigh!=par){
                int timeByChild=minTimetoCollectApples(graph,neigh,curr,hasApple);
                if(timeByChild !=0 || hasApple.get(neigh)) time+=timeByChild +2;
            }
            
        }
        return time;
    }
}