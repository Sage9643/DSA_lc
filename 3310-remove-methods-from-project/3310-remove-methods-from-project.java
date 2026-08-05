class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int i[]:invocations){
            int u=i[0];
            int v=i[1];
            graph[u].add(v);
        } 

        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[n];

        q.add(k);
        vis[k]=true;
        
        while(!q.isEmpty()){
            int curr=q.remove();

            for(int i=0;i<graph[curr].size();i++){
                int neigh=graph[curr].get(i);
                if(!vis[neigh]){
                    q.add(neigh);
                    vis[neigh]=true;
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        boolean valid=true;

        for(int i[]:invocations){
            int u=i[0];
            int v=i[1];

            if(!vis[u] && vis[v]){
                valid=false;
                break;
            }
        }if(!valid){
            for(int i=0;i<n;i++) ans.add(i);
        }
        else{
            for(int i=0;i<n;i++){
                if(!vis[i]) ans.add(i);
            }
        }
        return ans;


    }
}