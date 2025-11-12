class Solution {
    public int minIncrementForUnique(int[] arr) {
        int cnt=0;
        Arrays.sort(arr);
        int last=arr[0];

        for(int i=1;i<arr.length;i++){
            if(last<arr[i]) last=arr[i];
            else{
                cnt+=last-arr[i]+1;arr[i]=last+1;last++;
            }    
        }return cnt;
    }
}