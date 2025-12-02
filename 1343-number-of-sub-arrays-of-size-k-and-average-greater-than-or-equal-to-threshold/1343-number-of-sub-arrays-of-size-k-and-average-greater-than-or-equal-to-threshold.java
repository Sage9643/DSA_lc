class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cnt=0;long sum=0;
        int i=0,j=0;
        while(j<k) sum+=arr[j++];

        if(sum/k>=threshold) cnt++;
        sum-=arr[i++];

        while(j<arr.length){
            sum+=arr[j];
            if(sum/k>=threshold) cnt++;
            sum-=arr[i++];j++;
        }return cnt;
    }
}