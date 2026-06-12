class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans=new ArrayList<>();

        int dt[]=new int[n];
        int low[]=new int[n];
        boolean vis[]=new boolean[n];
        int time=0;

        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(List<Integer> c:connections){
            graph[c.get(0)].add(c.get(1));
            graph[c.get(1)].add(c.get(0));
        }

        for(int i=0;i<n;i++){
            if(!vis[i]) dfs(graph,dt,low,time,vis,i,-1,ans);
        }
        return ans;
    }
    public static void dfs(ArrayList<Integer> graph[],int[] dt,int low[],int time,boolean vis[],int curr,int par,List<List<Integer>> ans){
        vis[curr]=true;
        low[curr]=dt[curr]=++time;

        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);

            if(neigh==par) continue;
            else if(!vis[neigh]){
                dfs(graph,dt,low,time,vis,neigh,curr,ans);

                low[curr]=Math.min(low[curr],low[neigh]);
                if(dt[curr]<low[neigh]){
                    List<Integer> arr=new ArrayList<>();
                    arr.add(curr);
                    arr.add(neigh);
                    ans.add(arr);
                }
            }else{
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
        }

    }
}