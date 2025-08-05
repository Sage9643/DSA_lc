class Solution {
    public void gameOfLife(int[][] ans) {
        int board[][]=new int[ans.length][ans[0].length];
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                board[i][j]=ans[i][j];
            }
        }
        int rows=board.length,cols=board[0].length;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){            
                int oneCount=0;
                if(row<rows-1 && board[row+1][col]==1) oneCount++;
                if(col<cols-1 && board[row][col+1]==1) oneCount++;
                if(col>0 && board[row][col-1]==1) oneCount++;
                if(row>0 && board[row-1][col]==1) oneCount++;
                if(row>0 && col>0 && board[row-1][col-1]==1) oneCount++;
                if(row<rows-1 && col<cols-1 && board[row+1][col+1]==1) oneCount++;
                if(row<rows-1 && col>0 && board[row+1][col-1]==1) oneCount++;
                if(row>0 && col<cols-1 && board[row-1][col+1]==1) oneCount++;
                if(oneCount<2) ans[row][col]=0;
                if(oneCount==3) ans[row][col]=1;
                if(oneCount>3) ans[row][col]=0;
            }
        }
    }
}