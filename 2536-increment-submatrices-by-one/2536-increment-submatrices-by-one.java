class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int arr[][]=new int[n][n];int simulate[][]=new int[n+1][n+1];
        
        for(int[] query:queries){
            simulate[query[0]][query[1]]++;
            simulate[query[2]+1][query[3]+1]++;
            simulate[query[2]+1][query[1]]--;
            simulate[query[0]][query[3]+1]--;
        }for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int topleft=0,left=0,top=0;
                if((i!=0 && j!=0)) topleft=arr[i-1][j-1];
                if(i!=0) top=arr[i-1][j];
                if(j!=0) left=arr[i][j-1];

                arr[i][j]=(simulate[i][j]+left+top)-topleft;
            }
        }return arr;
    }
}