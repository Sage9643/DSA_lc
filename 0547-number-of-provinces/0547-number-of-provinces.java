class Solution {
    static int cnt;
    public int findCircleNum(int[][] isConnected) {
        cnt=0;
        int v=isConnected[0].length;
        ArrayList<Integer> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++) graph[i]=new ArrayList<>();
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isConnected[i][j]==1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        boolean vis[]=new boolean[v];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                findCircleNumUtil(graph,i,vis);
                cnt++;
            }
        }return cnt;
    }public static void findCircleNumUtil(ArrayList<Integer> graph[],int curr,boolean vis[]){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);
            if(!vis[neigh]){
                findCircleNumUtil(graph,neigh,vis);
            }
        }
    }
}