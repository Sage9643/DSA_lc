class Solution {
    public int assignEdgeWeights(int[][] edges) {
        HashSet<Integer> set=new HashSet<>();
        for(int e[]:edges){
            set.add(e[0]);
            set.add(e[1]);
        }
        
        ArrayList<Integer> graph[]=new ArrayList[set.size()];
        for(int i=0;i<set.size();i++) graph[i]=new ArrayList<>();

        for(int e[]:edges){
            graph[e[0]-1].add(e[1]);
            graph[e[1]-1].add(e[0]);
        }

        boolean vis[]=new boolean[set.size()];

        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(-1);

        int level=-1;

        while(!q.isEmpty()){
            int curr=q.remove();

            if(curr==-1){
                level++;
                if(!q.isEmpty()) q.add(-1);
                else break;
            }else{
                vis[curr-1]=true;
                for(int i=0;i<graph[curr-1].size();i++){
                    if(!vis[graph[curr-1].get(i)-1]) q.add(graph[curr-1].get(i));
                }
            }
        }long mod=1000000007;
        long ans=1;
        for(int i=1;i<level;i++) ans=((ans%mod)*2)%mod;
        return (int)ans;
    }
}