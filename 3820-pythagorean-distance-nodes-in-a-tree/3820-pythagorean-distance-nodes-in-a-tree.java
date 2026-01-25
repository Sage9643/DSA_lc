class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        ArrayList<Integer> graph[]=new ArrayList[n];

        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();

        for(int e[]:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int distx[]=bfs(n,x,graph);
        int disty[]=bfs(n,y,graph);
        int distz[]=bfs(n,z,graph);

        int cnt=0;

        for(int i=0;i<n;i++){
            int dx=distx[i];
            int dy=disty[i];
            int dz=distz[i];

            int arr[]={dx,dy,dz};
            

            Arrays.sort(arr);
            System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);

            if((((long)arr[0]*arr[0])+((long)arr[1]*arr[1]))==((long)arr[2]*arr[2])) cnt++;
        }
        return cnt;
    }
    public static int[] bfs(int dest,int src,ArrayList<Integer> graph[]){
        int dist[]=new int[dest];
        Arrays.fill(dist,Integer.MAX_VALUE);

        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        dist[src]=0;

        while(!q.isEmpty()){
            int curr=q.remove();

            for(int i=0;i<graph[curr].size();i++){
                int neigh=graph[curr].get(i);
                if(dist[neigh]==Integer.MAX_VALUE){
                    dist[neigh]=dist[curr]+1;
                    q.add(neigh);
                }
            }
        }return dist;
    }
}