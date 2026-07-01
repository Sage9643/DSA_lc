class Solution {
    public int swimInWater(int[][] grid) {
        int end=0,start=0,n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) end=Math.max(end,grid[i][j]);
        }
        int ans=end;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(check(grid,mid)){
                ans=mid;
                end=mid-1;
            }else start=mid+1;
        }
        return ans;
    }
    public static boolean check(int grid[][],int mid){
        Queue<int[]> q=new LinkedList<>();
        int n=grid.length;
        q.add(new int[]{0,0});

        boolean vis[][]=new boolean[n][n];
        vis[0][0]=true;

        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};

        if(grid[0][0]>mid) return false;

        while(!q.isEmpty()){
            int curr[]=q.remove();

            if(curr[0]==n-1 && curr[1]==n-1) return true;

            for(int i=0;i<4;i++){
                int r=curr[0]+dr[i];
                int c=curr[1]+dc[i];

                if(r>=0 && r<n && c>=0 && c<n && !vis[r][c]){
                    if(grid[r][c]>mid) continue;

                    vis[r][c]=true;
                    q.add(new int[]{r,c});
                }
            }
        }return false;

    }
}