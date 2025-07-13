class Solution {
    public boolean isValidSudoku(char[][] sudoku) {
        return sudokuvalidation(sudoku,0,0);

    }public static boolean sudokuvalidation(char sudoku[][],int row,int col){
        if(row==9){
            return true;
        }
        int nextrow=row,nextcol=col+1;
        
        if(col+1==9){
            nextrow=row+1;
            nextcol=0;
        
        }
        if(sudoku[row][col]!='.'){
            if(!isSafe(sudoku,row,col,sudoku[row][col])){
                return false;
            }
        }
        return sudokuvalidation(sudoku,nextrow,nextcol);
        
    }public static boolean isSafe(char sudoku[][],int row,int col,char element){
        //row
        for(int i=0;i<9;i++){
            if(i!=row && sudoku[i][col]==element){
                return false;
            }
        }//col
        for(int i=0;i<9;i++){
            if(i!=col && sudoku[row][i]==element){
                return false;
            }
        }//grid
        int startrow=(row/3)*3;
        int startcol=(col/3)*3;
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcol;j<startcol+3;j++){
                if ((i != row || j != col) && sudoku[i][j] == element){
                    return false;
                }
            }
        }return true;
    }

}