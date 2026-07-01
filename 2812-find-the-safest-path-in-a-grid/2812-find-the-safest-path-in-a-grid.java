class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        int dist[][]=new int[n][n];
        boolean vis[][]=new boolean[n][n];
        Queue<int[]> q=new LinkedList<>();

        for(int[] row:dist) Arrays.fill(row, -1);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=true;
                    dist[i][j]=0;
                }
            }
        }int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};

        while(!q.isEmpty()){
            int curr[]=q.remove();

            for(int i=0;i<4;i++){
                int r=curr[0]+dr[i];
                int c=curr[1]+dc[i];

                if(r>=0 && r<n && c>=0 && c<n && !vis[r][c]){
                    dist[r][c]=1+curr[2];
                    vis[r][c]=true;
                    q.add(new int[]{r,c,1+curr[2]});
                }
            }
        }int start=0,end=2*n;
        int ans=0;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(valid(dist,mid)){
                ans=mid;
                start=mid+1;
            }else end=mid-1;
        }
        return ans;   
    }
    public static boolean valid(int dist[][],int mid){

        if(dist[0][0]<mid) return false;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        
        int n=dist.length;

        boolean vis[][]=new boolean[n][n];
        vis[0][0]=true;

        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};

        while(!q.isEmpty()){
            int curr[]=q.remove();

            if(curr[0]==n-1 && curr[1]==n-1) return true;

            for(int i=0;i<4;i++){
                int r=curr[0]+dr[i];
                int c=curr[1]+dc[i];

                if(r>=0 && r<n && c>=0 && c<n && !vis[r][c]){
                    if(dist[r][c]<mid) continue;

                    q.add(new int[]{r,c});
                    vis[r][c]=true;
                }
            }
        }return false;
    } 
    
}