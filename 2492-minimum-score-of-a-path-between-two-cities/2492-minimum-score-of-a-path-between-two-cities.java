class Solution {
    static int min;
    public int minScore(int n, int[][] roads) {
        ArrayList<int[]> graph[]=new ArrayList[n+1];
        for(int i=0;i<n+1;i++) graph[i]=new ArrayList<>();

        for(int r[]:roads) {
            graph[r[0]].add(new int[]{r[1],r[2]});
            graph[r[1]].add(new int[]{r[0],r[2]});
        }
        boolean vis[]=new boolean[n+1];
        min=Integer.MAX_VALUE;

        dfs(graph,1,vis);        
        return min;
    }
    public static void dfs(ArrayList<int[]> graph[],int curr,boolean vis[]){
        vis[curr]=true;
        

        for(int i=0;i<graph[curr].size();i++){
            int neigh[]=graph[curr].get(i);
            min=Math.min(min,neigh[1]);

            if(!vis[neigh[0]]){
                
                dfs(graph,neigh[0],vis);
            }
        }

        
    }
}