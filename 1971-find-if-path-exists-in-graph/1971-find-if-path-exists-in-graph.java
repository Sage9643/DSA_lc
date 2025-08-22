class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            graph[edge[0]].add(new int[]{edge[0],edge[1]});
            graph[edge[1]].add(new int[]{edge[1],edge[0]});
        }

        return dfs(graph,source,destination,new boolean[n]);
    }
    public static boolean dfs(ArrayList<int[]>[]graph,int source,int destination,boolean[] visited){
        if(source==destination) return true;
        visited[source]=true;

        for(int i=0;i<graph[source].size();i++){
            if(!visited[graph[source].get(i)[1]]){
                visited[graph[source].get(i)[1]]=true;
                if(dfs(graph,graph[source].get(i)[1],destination,visited))return true;
            }
        }return false;
    }
}