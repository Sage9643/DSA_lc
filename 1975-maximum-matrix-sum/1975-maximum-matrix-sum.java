class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int neg=0;
        long sum=0;
        int minel=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]<0) neg++;
                sum+=Math.abs(matrix[i][j]);
                minel=Math.min(minel,Math.abs(matrix[i][j]));
            }
        }if(neg%2!=0){
            sum-=(2*minel);
        }return sum;
    }
}