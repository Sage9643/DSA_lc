class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        if(equals(mat,target)) return true;
        int t1[][]=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                t1[i][j]=mat[n-j-1][i];
            }
        }if(equals(t1,target)) return true;
        int t2[][]=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                t2[i][j]=t1[n-j-1][i];
            }
        }if(equals(t2,target)) return true;
        int t3[][]=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                t3[i][j]=t2[n-j-1][i];
            }
        }if(equals(t3,target)) return true;
        return false;
    }
    public static boolean equals(int arr[][],int target[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]!=target[i][j]) return false;
            }
        }return true;
    }
} 