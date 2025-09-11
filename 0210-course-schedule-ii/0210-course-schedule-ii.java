class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();

        for(int i=0;i<prerequisites.length;i++)graph[prerequisites[i][0]].add(prerequisites[i][1]);

        int indegree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++) indegree[prerequisites[i][1]]++;

        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> sorted=new ArrayList<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.remove();
            sorted.add(curr);

            for(int i=0;i<graph[curr].size();i++){
                indegree[graph[curr].get(i)]--;
                if(indegree[graph[curr].get(i)]==0) q.add(graph[curr].get(i));
            }
        }int[] res=new int[sorted.size()];
        Collections.reverse(sorted);
        if(sorted.size()!=numCourses) return new int[]{};
        for (int i=0;i<sorted.size();i++) {
            res[i]=sorted.get(i);
        }
        return res;
    }
}