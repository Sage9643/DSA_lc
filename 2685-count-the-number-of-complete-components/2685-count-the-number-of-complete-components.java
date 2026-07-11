class Solution {
    static int v,e;
    public int countCompleteComponents(int n, int[][] edges) {
        int cnt=0;

        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int e[]:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean vis[]=new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                v=0;e=0;
                dfs(graph,i,vis);
                System.out.println(e);

                if(((v)*(v-1))/2==(e/2)) cnt++;
            }
        }
        return cnt;
    }
    public static void dfs(ArrayList<Integer> graph[],int curr,boolean vis[]){
        vis[curr]=true;
        v++;

        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);
            e++;

            if(!vis[neigh]){
                dfs(graph,neigh,vis);
                
            }
        }
    }
}