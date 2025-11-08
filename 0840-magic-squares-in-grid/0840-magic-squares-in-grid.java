class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        boolean occ[]=new boolean[9];
        for(int rows=0;rows<grid.length-2;rows++){
            for(int cols=0;cols<grid[0].length-2;cols++){
                if(isMagicSquare(grid,rows,cols,occ)) count++;
            }
        }return count;
    }
    public static boolean isMagicSquare(int[][] matrix,int row,int col,boolean[] occ){
        //checking if all elements are distinct and between[1,9]
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(matrix[i][j]>9 || matrix[i][j]<1) return false;
                else occ[matrix[i][j]-1]=true;
            }
        }for(int i=0;i<9;i++){
            if(!occ[i]){
                Arrays.fill(occ,false);return false;
            }
        }Arrays.fill(occ,false);
        int sum=matrix[row][col]+matrix[row][col+1]+matrix[row][col+2];
        //sum of diagonals check
        if(matrix[row][col]+matrix[row+1][col+1]+matrix[row+2][col+2]!=sum || matrix[row][col+2]+matrix[row+1][col+1]+matrix[row+2][col]!=sum) return false;

        //sum of rows check
        if(matrix[row+1][col]+matrix[row+1][col+1]+matrix[row+1][col+2]!=sum || matrix[row+2][col]+matrix[row+2][col+1]+matrix[row+2][col+2]!=sum) return false;

        //sum of cols check
        if(matrix[row][col]+matrix[row+1][col]+matrix[row+2][col]!=sum || matrix[row][col+1]+matrix[row+1][col+1]+matrix[row+2][col+1]!=sum || matrix[row][col+2]+matrix[row+1][col+2]+matrix[row+2][col+2]!=sum) return false;

        return true;
    }
}