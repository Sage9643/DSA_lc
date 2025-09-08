class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean vis[]=new boolean[graph.length];
        int col[]=new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i] && !isBipartiteUtil(graph,i,vis,col)) return false;
        }return true;
    }private boolean isBipartiteUtil(int graph[][],int curr,boolean vis[],int col[]){
        vis[curr]=true;
        if(col[curr]==0) col[curr]=1;

        Queue<Integer> q=new LinkedList<>();
        q.add(curr);

        while(!q.isEmpty()){
            int current=q.remove();

            for(int i=0;i<graph[current].length;i++){
                if(!vis[graph[current][i]]){
                    vis[graph[current][i]]=true;
                    col[graph[current][i]]=col[current]==1?2:1;
                    q.add(graph[current][i]);
                }else{
                    if(col[current]==col[graph[current][i]]) return false;
                }
            }
        }return true;
    }
}