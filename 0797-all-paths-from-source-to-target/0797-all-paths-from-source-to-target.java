class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        
        allPathsSourceTargetUtil(graph,0,graph.length-1,ans,path);
        return ans;
    }
    public static void allPathsSourceTargetUtil(int[][] graph,int curr,int dest,List<List<Integer>> ans,ArrayList<Integer> path){
        if(curr==dest){
            path.add(curr);
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(curr);
        for(int i=0;i<graph[curr].length;i++){
            allPathsSourceTargetUtil(graph,graph[curr][i],dest,ans,path);
            path.remove(path.size()-1);
        }
    }
}