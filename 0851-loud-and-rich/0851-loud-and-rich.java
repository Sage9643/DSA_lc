class Solution {
    static int[] ans;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int v=quiet.length;
        int[] dp=quiet.clone();

        ans=new int[v];
        Arrays.fill(ans,-1);

        ArrayList<Integer> graph[]=new ArrayList[v];

        for(int i=0;i<v;i++) graph[i]=new ArrayList<>();

        for(int r[]:richer){
            graph[r[1]].add(r[0]);
        }
        for(int i=0;i<v;i++){
            dfs(graph,dp,i);
        }
        return ans;

    }public static int dfs(ArrayList<Integer> graph[],int quiet[],int curr){

        if(ans[curr]!=-1) return ans[curr];
        ans[curr]=curr;

        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);
            int can=dfs(graph,quiet,neigh);

            if(quiet[can]<quiet[ans[curr]]) ans[curr]=can;
        }return ans[curr];
    }
}