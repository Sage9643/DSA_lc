class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size(),n=grid.get(0).size();
        int dist[][]=new int[m][n];

        for(int row[]:dist) Arrays.fill(row,Integer.MAX_VALUE);
        dist[0][0]=grid.get(0).get(0)==0?0:1;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);

        pq.add(new int[]{0,0,dist[0][0]});

        while(!pq.isEmpty()){
            int curr[]=pq.remove();

            int dr[]={-1,0,1,0};
            int dc[]={0,1,0,-1};

            for(int i=0;i<4;i++){
                int r=curr[0]+dr[i];
                int c=curr[1]+dc[i];

                if(r>=0 && r<m && c>=0 && c<n){
                    if(dist[r][c]>curr[2]+grid.get(r).get(c)){
                        dist[r][c]=curr[2]+grid.get(r).get(c);
                        pq.add(new int[]{r,c,dist[r][c]});
                    }
                }
            }
        }
        return health-dist[m-1][n-1]>0;
    }
}