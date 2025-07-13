class Solution {
    public boolean checkValidGrid(int[][] grid) {
        return knighttour(grid,0,0,0);
    }
    public static boolean knighttour(int grid[][],int row,int col,int expval){
        //base case
        if(row>=grid.length || col>=grid.length || row<0 || col<0 ||grid[row][col]!=expval){
            return false;
        }if(expval==grid.length*grid.length-1){
            return true;
        }//kaam ,checking for all poosible case
        boolean ans1=knighttour(grid,row-2,col+1,expval+1);
        boolean ans2=knighttour(grid,row-1,col+2,expval+1);
        boolean ans3=knighttour(grid,row+1,col+2,expval+1);
        boolean ans4=knighttour(grid,row+2,col+1,expval+1);
        boolean ans5=knighttour(grid,row+2,col-1,expval+1);
        boolean ans6=knighttour(grid,row+1,col-2,expval+1);
        boolean ans7=knighttour(grid,row-1,col-2,expval+1);
        boolean ans8=knighttour(grid,row-2,col-1,expval+1);
        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8; 
    }
}