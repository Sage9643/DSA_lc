class Solution {
    public int longestCycle(int[] edges) {
        int v=edges.length;
        boolean vis[]=new boolean[v];
        int max=-1;

        for(int i=0;i<v;i++){
            int d=0;
            int node=i;

            if(vis[node]) continue;

            HashMap<Integer,Integer> map=new HashMap<>();

            while(node!=-1 && !vis[node]){
                map.put(node,d++);
                vis[node]=true;

                node=edges[node];
            }
            if(node!=-1 && map.containsKey(node)){
                max=Math.max(max,d-map.get(node));
            }
        }return max;
    }
}