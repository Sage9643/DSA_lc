class Solution {
    public int findLucky(int[] arr) {
        int largest=arr[0];
        for(int i=0;i<arr.length;i++){
            largest=Math.max(arr[i],largest);
        }
        int count[]=new int[largest];
        for(int i=0;i<arr.length;i++){
            count[arr[i]-1]++;
        }for(int i=count.length-1;i>=0;i--){
            if(count[i]==i+1){
                return i+1;
            }
        }return -1;
    }
}