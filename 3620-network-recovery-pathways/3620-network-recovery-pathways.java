class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int start=Integer.MAX_VALUE,end=Integer.MIN_VALUE;
        
        int v=online.length;

        ArrayList<int[]> graph[]=new ArrayList[v];

        for(int i=0;i<v;i++) graph[i]=new ArrayList<>();

        for(int e[]:edges){
            
            graph[e[0]].add(new int[]{e[1],e[2]});
            start=Math.min(start,e[2]);
            end=Math.max(end,e[2]);
            
        }

        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(check(graph,mid,v-1,k,online)){
                ans=mid;
                start=mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }
    public static boolean check(ArrayList<int[]> graph[],int mid,int n,long k,boolean online[]){

        long dist[]=new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);

        dist[0]=0;

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long curr[]=pq.remove();

            if(curr[1]>k) continue;
            if(curr[1]>dist[(int)curr[0]]) continue;

            if(curr[0]==n) return curr[1]<=k;

            

            for(int i=0;i<graph[(int)curr[0]].size();i++){
                int neigh[]=graph[(int)curr[0]].get(i);

                if(neigh[1]<mid) continue;

                if(neigh[0]!=n && !online[neigh[0]]) continue;

                if(dist[neigh[0]]>curr[1]+neigh[1]){
                    dist[neigh[0]]=curr[1]+neigh[1];
                    pq.add(new long[]{neigh[0],dist[neigh[0]]});
                }
            }
        }return false;
    }
}