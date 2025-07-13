class Solution {
    public int diagonalSum(int[][] matrix) {
        int total=0;
        for(int i=0;i<matrix.length;i++){
            total+=matrix[i][i];
            total+=matrix[i][matrix.length-1-i];
        }if(matrix.length%2!=0){
            total-=matrix[matrix.length/2][matrix.length/2];
        }return total;
    }
}