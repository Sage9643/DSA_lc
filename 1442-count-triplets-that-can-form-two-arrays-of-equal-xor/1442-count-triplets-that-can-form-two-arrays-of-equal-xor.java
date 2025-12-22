class Solution {
    public int countTriplets(int[] arr) {
        int cnt=0;

        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                int lxor=0;
                for(int k=i;k<=j;k++){
                    lxor^=arr[k];
                }int rxor=0;
                for(int k=j+1;k<arr.length;k++){
                    rxor^=arr[k];
                    if(lxor==rxor)cnt++;
                }
            }
        }return cnt;
    }
}