class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        //Approach if all the elements are in range [1,m*n] and are unique
        int m=mat.length,n=mat[0].length;
        int[] position=new int[m*n+1];//storing index of mat elements in 1d array form
        int remainingRows[]=new int[m];
        int remainingCols[]=new int[n];

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                int pos=row*n+col;
                position[mat[row][col]]=pos;
                remainingRows[row]++;
                remainingCols[col]++;
            }
        }
        for(int i=0;i<arr.length;i++){
            int pos=position[arr[i]];
            remainingRows[pos/n]--;
            if(remainingRows[pos/n]==0) return i;

            remainingCols[pos%n]--;
            if(remainingCols[pos%n]==0) return i;
        }
        return -1;
    }
}