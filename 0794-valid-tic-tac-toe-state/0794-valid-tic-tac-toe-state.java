class Solution {
    public boolean validTicTacToe(String[] board) {
        int X=0,O=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='X') X++;
                else if(board[i].charAt(j)=='O') O++;
            }
        }if((X-O)<0 || (X-O)>1) return false;
        
        boolean Xwin=winner(board,'X');
        boolean Owin=winner(board,'O');

        if(Xwin && Owin) return false;//both cant win
        else if(Xwin && X!=O+1) return false;//if X wins then it should occur one more than O
        else if(Owin && O!=X) return false;//if O wins then count of O and X should be same
        return true;

    }public static boolean winner(String board[],char move){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(0)==move && board[i].charAt(1)==move && board[i].charAt(2)==move) return true;
                if(board[0].charAt(i)==move && board[1].charAt(i)==move && board[2].charAt(i)==move) return true;
            }
        }if(board[0].charAt(0)==move && board[1].charAt(1)==move && board[2].charAt(2)==move) return true;
        if(board[0].charAt(2)==move && board[1].charAt(1)==move && board[2].charAt(0)==move) return true;
        return false;
    } 
}