class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length,m=moveTime[0].length;
        int time[][]=new int[n][m];

        for(int t[]:time) Arrays.fill(t,Integer.MAX_VALUE);
        time[0][0]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,time[0][0]});

        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};

        while(!pq.isEmpty()){
            int curr[]=pq.remove();

            for(int i=0;i<4;i++){
                int r=curr[0]+dr[i];
                int c=curr[1]+dc[i];

                if(r>=0 && r<n && c>=0 && c<m){
                    int dist=Math.max(moveTime[r][c],curr[2])+1;

                    if(time[r][c]>dist){
                        time[r][c]=dist;
                        pq.add(new int[]{r,c,time[r][c]});
                    }
                }
            }

        }
        return time[n-1][m-1];
    }
}