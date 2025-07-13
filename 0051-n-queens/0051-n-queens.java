class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];
        List<List<String>> arr=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='.';
            }
        }nqueens(board,0,arr);
        return arr;
    }public static void nqueens(char board[][],int row,List<List<String>> arr){
    if(row==board.length){//base case
        arr.add(Printboard(board));
        return;
    }for(int col=0;col<board.length;col++){
        if(isSafe(board,row,col)){
            board[row][col]='Q';
            nqueens(board,row+1,arr);
            board[row][col]='.';
        }
    }
      
      
    }public static boolean isSafe(char board[][],int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }for(int i=row-1,j=col-1;i>=0;i--,j--){
            if(i>=0 && j>=0){
                if(board[i][j]=='Q'){
                    return false;
                }
            }
        }for(int i=row-1,j=col+1;i>=0;i--,j++){
            if(i>=0 && j<board.length){
                if(board[i][j]=='Q'){
                    return false;
                }
            }
        
        }return true;
    }public static List<String> Printboard(char board[][]){
        List<String> res=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb=new StringBuilder("");
            for(int j=0;j<board.length;j++){
                sb.append(board[i][j]);
            }res.add(sb.toString());
        }return res;
    }
}