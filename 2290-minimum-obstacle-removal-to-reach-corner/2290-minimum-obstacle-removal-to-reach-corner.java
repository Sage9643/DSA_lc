class Solution {
    public int minimumObstacles(int[][] grid) {

        int m=grid.length,n=grid[0].length;
        int dist[][]=new int[m][n];

        for(int d[]:dist) Arrays.fill(d,Integer.MAX_VALUE);
        dist[0][0]=0;

        Deque<int[]> dq=new LinkedList<>();
        dq.addFirst(new int[]{0,0,0});

        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};

        while(!dq.isEmpty()){
            int curr[]=dq.removeFirst();

            for(int i=0;i<4;i++){
                int r=curr[0]+dr[i];
                int c=curr[1]+dc[i];

                if(r>=0 && r<m && c>=0 && c<n){
                    int d=curr[2]+grid[r][c];
                    if(dist[r][c]>d){
                        dist[r][c]=d;

                        if(grid[r][c]==0) dq.addFirst(new int[]{r,c,dist[r][c]});
                        else dq.addLast(new int[]{r,c,dist[r][c]});
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}