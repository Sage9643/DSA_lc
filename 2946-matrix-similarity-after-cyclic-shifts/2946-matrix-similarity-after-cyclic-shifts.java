class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat[0].length;
        k%=n;

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<n;j++){
                if(i%2==0){
                    int curr=mat[i][j];
                    int idx=((j-k)+n)%n;
                    if(mat[i][idx]!=curr) return false;
                }else{
                    int curr=mat[i][j];
                    int idx=(j+k)%n;
                    if(mat[i][idx]!=curr) return false;
                }
            }
        }return true;
    }
}