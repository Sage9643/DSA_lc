class Solution {
    public int[] pathsWithMaxScore(List<String> board) {

        int mod=1000000007;
        int n=board.size(),m=board.get(0).length();
        int max[][]=new int[n][m];
        long ways[][]=new long[n][m];

        for(int arr[]:max) Arrays.fill(arr,Integer.MIN_VALUE);

        ways[n-1][m-1]=1;
        max[n-1][m-1]=0;
        
        int dr[]={-1,-1,0};
        int dc[]={0,-1,-1};

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(max[i][j]==Integer.MIN_VALUE) continue;
                
                for(int k=0;k<3;k++){
                    int r=i+dr[k];
                    int c=j+dc[k];

                    if(r>=0 && r<n && c>=0 && c<m && board.get(r).charAt(c)!='X'){
                        int dist=board.get(r).charAt(c)=='E' || board.get(r).charAt(c)=='S'?max[i][j]+0:max[i][j]+ (board.get(r).charAt(c)-'0');
                        if(dist==max[r][c]) ways[r][c]=(ways[r][c]+ways[i][j])%mod;
                        else if(dist>max[r][c]){
                            max[r][c]=dist;
                            ways[r][c]=ways[i][j];
                        }
                    }
                }
            }
        }if(max[0][0]==Integer.MIN_VALUE) return new int[]{0,0};
        return new int[]{max[0][0],(int)ways[0][0]};
    }
    
}