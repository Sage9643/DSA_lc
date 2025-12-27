class Solution {
    public int getWinner(int[] arr, int k) {
        int conswin=0;
        int winner=Math.max(arr[0],arr[1]);

        int i=0,j=1;

        while(i<arr.length && j<arr.length){
            int p1=arr[i],p2=arr[j];
            int greater=Math.max(p1,p2);
            if(winner==greater) {
                conswin++;
                if(p1>p2) j++;
                else{
                    i=j;j++;
                }
            }else{
                winner=greater;conswin=1;
                i=j;j++;
            }if(conswin==k) return winner;
        }return winner;
    }
}