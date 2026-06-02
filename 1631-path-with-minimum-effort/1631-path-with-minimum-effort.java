class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int dist[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=0 || j!=0) dist[i][j]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int curr[]=pq.remove();
            int i=curr[0];
            int j=curr[1];
            int d=curr[2];

            if(i>0){
                
                if(dist[i-1][j]>Math.max(d,Math.abs(heights[i-1][j]-heights[i][j]))){
                    dist[i-1][j]=Math.max(d,Math.abs(heights[i-1][j]-heights[i][j]));
                    pq.add(new int[]{i-1,j,Math.max(d,Math.abs(heights[i-1][j]-heights[i][j]))});
                }
            }if(j<m-1){
                
                if(dist[i][j+1]>Math.max(d,Math.abs(heights[i][j+1]-heights[i][j]))){
                    dist[i][j+1]=Math.max(d,Math.abs(heights[i][j+1]-heights[i][j]));
                    pq.add(new int[]{i,j+1,Math.max(d,Math.abs(heights[i][j+1]-heights[i][j]))});
                }
                
            }if(j>0){
                
                if(dist[i][j-1]>Math.max(d,Math.abs(heights[i][j-1]-heights[i][j]))){
                    dist[i][j-1]=Math.max(d,Math.abs(heights[i][j-1]-heights[i][j]));
                    pq.add(new int[]{i,j-1,Math.max(d,Math.abs(heights[i][j-1]-heights[i][j]))});
                
                }
            }if(i<n-1){
                
                if(dist[i+1][j]>Math.max(d,Math.abs(heights[i+1][j]-heights[i][j]))){
                    dist[i+1][j]=Math.max(d,Math.abs(heights[i+1][j]-heights[i][j]));
                    pq.add(new int[]{i+1,j,Math.max(d,Math.abs(heights[i+1][j]-heights[i][j]))});
                
                }
            }
        }return dist[n-1][m-1];
    }
}