class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal=0;
        int maxArea=0;

        for(int i=0;i<dimensions.length;i++){
            double currDiagonal=dimensions[i][0]*dimensions[i][0]+dimensions[i][1]*dimensions[i][1];
            if(maxDiagonal<=currDiagonal){
                maxArea=maxDiagonal==currDiagonal?Math.max(dimensions[i][0]*dimensions[i][1],maxArea):dimensions[i][0]*dimensions[i][1];
                maxDiagonal=currDiagonal;
                
            }
        }return maxArea;

    }
}