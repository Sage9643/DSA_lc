class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        ArrayList<Integer> neigh[]=new ArrayList[v];
        for(int i=0;i<v;i++) neigh[i]=new ArrayList<>();

        int outdegree[]=new int[v];

        int node=0;
        for(int arr[]:graph){
            outdegree[node]=arr.length;
            for(int i=0;i<arr.length;i++){
                neigh[arr[i]].add(node);
            }node++;
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<v;i++){
            if(outdegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.remove();
            ans.add(curr);

            for(int i=0;i<neigh[curr].size();i++){
                int prev=neigh[curr].get(i);
                outdegree[prev]--;
                if(outdegree[prev]==0) q.add(prev);
            }
        }Collections.sort(ans);
        return ans;
    }
}