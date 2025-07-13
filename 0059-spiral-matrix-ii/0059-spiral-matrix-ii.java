class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][]=new int[n][n];
        int startrow=0;
        int endrow=n-1;
        int startcol=0;
        int endcol=n-1;
        int element=1;
        while(startrow-endrow<=0){
            for(int i=startcol;i<=endcol;i++){
                arr[startrow][i]=element++;
            }for(int i=startrow+1;i<=endrow;i++){
                arr[i][endcol]=element++;
            }for(int i=endcol-1;i>=startcol;i--){
                arr[endrow][i]=element++;
            }for(int i=endrow-1;i>startrow;i--){
                arr[i][startcol]=element++;
            }startrow++;
            endrow--;
            startcol++;
            endcol--;
        }return arr;
    }
}