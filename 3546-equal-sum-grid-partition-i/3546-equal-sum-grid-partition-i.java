class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        double rowsum[]=new double[n+1];
        double colsum[]=new double[m+1];
        rowsum[0]=0;
        colsum[0]=0;
        double totsum=0;
        int idx=1;
        for(int i=0;i<n;i++){
            double rsum=0;
            for(int j=0;j<m;j++){
                rsum+=grid[i][j];
                totsum+=grid[i][j];
            }rowsum[idx]=rowsum[idx-1]+rsum;
            idx++;
        }
        idx=1;
        for(int i=0;i<m;i++){
            double csum=0;
            for(int j=0;j<n;j++){
                csum+=grid[j][i];
            }colsum[idx]=colsum[idx-1]+csum;
            idx++;
        }
        for(int i=0;i<n;i++){
            if((2*rowsum[i])==totsum) return true;
        }for(int i=0;i<m;i++){
            if((2*colsum[i])==totsum) return true;
        }
        return false;
    }
}