class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int dec=0;
        for(int i=x;i<x+k/2;i++){
            for(int j=y;j<y+k;j++){
                int temp=grid[i][j];
                grid[i][j]=grid[x+k-1-dec][j];
                grid[x+k-1-dec][j]=temp;
                
            }dec++;
        }return grid;
    }
}