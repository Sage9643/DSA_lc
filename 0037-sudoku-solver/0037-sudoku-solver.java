class Solution {
    public void solveSudoku(char[][] sudoku) {
        sudokusolver(sudoku,0,0);
    }public static boolean sudokusolver(char sudoku[][],int row,int col){
        if(row==9){
            return true;
        }int newrow=row,newcol=col+1;
        if(col+1==9){
            newrow=row+1;
            newcol=0;
        }if(sudoku[row][col]=='.'){
            for(char dig='1';dig<='9';dig++){
                if(isSafe(sudoku,row,col,dig)){
                    sudoku[row][col]=dig;
                    if(sudokusolver(sudoku,newrow,newcol)){
                        return true;
                    }sudoku[row][col] = '.';
                     
                }
            }
            return false;
        }else{
            return sudokusolver(sudoku,newrow,newcol);
        }
    }public static boolean isSafe(char sudoku[][],int row,int col,char dig){
        //col & row
        for(int i=0;i<sudoku.length;i++){
            if(sudoku[i][col]==dig || sudoku[row][i]==dig){
                return false;
            }
        }//grid
        for(int i=(row/3)*3;i<((row/3)*3)+3;i++){
            for(int j=(col/3)*3;j<((col/3)*3)+3;j++){
                if(sudoku[i][j]==dig){
                    return false;
                }
            }
        }return true;
    }
}