class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();

        for(int[] num:prerequisites) graph[num[1]].add(num[0]);
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycle(graph,i,vis,stack)) return false;
            }
        }return true;
    }
    public static boolean isCycle(ArrayList<Integer>[] graph,int curr,boolean[]vis,boolean[]stack){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            int edge=graph[curr].get(i);
            if(!vis[edge]){
                if(isCycle(graph,edge,vis,stack)) return true;
            } 
            else if(vis[edge] && stack[edge]) return true;
        }stack[curr]=false;
        return false;
    }
}