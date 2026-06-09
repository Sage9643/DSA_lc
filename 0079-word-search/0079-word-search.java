class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        boolean vis[][]=new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){

                    if(dfs(board,vis,i,j,word,1)) return true;
                }
            }
        }return false;
    }
    public static boolean dfs(char board[][],boolean vis[][],int r,int c,String word,int idx){
        int m=board.length,n=board[0].length;
        if(idx==word.length()) return true;

        vis[r][c]=true;

        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};

        boolean ans=false;

        for(int i=0;i<4;i++){
            int row=r+dr[i];
            int col=c+dc[i];


            if(row>=0 && row<m && col>=0 && col<n && !vis[row][col] && board[row][col]==word.charAt(idx)){
                ans|= dfs(board,vis,row,col,word,idx+1);
            }
        }vis[r][c]=false;
        return ans;
    }
}