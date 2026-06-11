class Solution {
    static int par[];
    static int size[];
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        par=new int[n*n];
        size=new int[n*n];

        Arrays.fill(size,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int idx=(i*n)+j;
                par[idx]=idx;
            }
        }for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int curr=(i*n)+j;
                    int dr[]={-1,0,1,0};
                    int dc[]={0,1,0,-1};

                    for(int k=0;k<4;k++){
                        int row=i+dr[k];
                        int col=j+dc[k];

                        if(row>=0 && row<n && col>=0 && col<n && grid[row][col]==1){
                            int idx=(row*n)+col;

                            int para=find(curr);
                            int parb=find(idx);

                            if(para!=parb) union(curr,idx);
                        }    
                    }
                }
            }
        }int maxsize=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){

                    int dr[]={-1,0,1,0};
                    int dc[]={0,1,0,-1};

                    int s=1;
                    HashSet<Integer> set=new HashSet<>();

                    for(int k=0;k<4;k++){
                        int row=i+dr[k];
                        int col=j+dc[k];

                        if(row>=0 && row<n && col>=0 && col<n && grid[row][col]==1){
                            int idx=(row*n)+col;
                            int par=find(idx);

                            if(!set.contains(par)) s+=size[par];
                            set.add(par);
                        }
                    }maxsize=Math.max(maxsize,s);
                }else{
                    int idx=(i*n)+j;
                    maxsize=Math.max(maxsize,size[find(idx)]);
                }
            }
        }
        return maxsize;
    }
    public static int find(int x){
        if(x==par[x]) return x;
        return par[x]=find(par[x]);
    }
    public static void union(int a,int b){
        int para=find(a);
        int parb=find(b);

        if(size[para]==size[parb]){
            par[parb]=para;
            size[para]+=size[parb];
        }
        else if(size[para]<size[parb]){
            par[para]=parb;
            size[parb]+=size[para];
        }else{
            par[parb]=para;
            size[para]+=size[parb];
        }
    }
}