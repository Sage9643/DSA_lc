class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int v=time.length;

        ArrayList<Integer> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++) graph[i]=new ArrayList<>();

        int indegree[]=new int[v];

        for(int r[]:relations){
            indegree[r[1]-1]++;
            graph[r[0]-1].add(r[1]);
        }
        int max[]=new int[v];
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<v;i++){
            if(indegree[i]==0) {q.add(i+1); max[i]=time[i];}
        }

        while(!q.isEmpty()){
            int curr=q.remove();
            
            for(int i=0;i<graph[curr-1].size();i++){
                int neigh=graph[curr-1].get(i);
                indegree[neigh-1]--;
                max[neigh-1]=Math.max(max[neigh-1],time[neigh-1]+max[curr-1]);
                if(indegree[neigh-1]==0) q.add(neigh);
            }
        }
        int total=0;
        for(int m:max) total=Math.max(total,m);
        return total;
    }
}