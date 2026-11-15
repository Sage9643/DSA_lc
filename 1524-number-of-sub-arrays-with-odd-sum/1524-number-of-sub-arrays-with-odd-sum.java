class Solution {
    public int numOfSubarrays(int[] arr) {
        long cnt=0;
        long oddsum=0;
        long evensum=1;
        long sum=0;

        for(int a:arr){
            sum+=a;
            if(sum%2==0){
                cnt+=oddsum;
                evensum++;
            }else{
                cnt+=evensum;
                oddsum++;
            }
        }
        return (int)(cnt%1000000007);
    }
}