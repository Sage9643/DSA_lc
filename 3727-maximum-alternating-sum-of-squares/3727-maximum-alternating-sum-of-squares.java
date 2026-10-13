class Solution {
    public long maxAlternatingSum(int[] nums) {
        int idx=0;
        long arr[]=new long[nums.length];
        for(int num:nums) arr[idx++]=num*num;
        Arrays.sort(arr);
        long arr2[]=new long[nums.length];
        for(int i=0;i<arr.length;i++) arr2[i]=arr[arr.length-1-i];
        
        long sum1=0;
        long sum2=0;
        int k=(int) Math.ceil((double)nums.length/2);

        for(int i=0;i<k;i++) sum1+=arr2[i];
        for(int i=k;i<arr2.length;i++) sum2+=arr2[i];

        return sum1-sum2;
    }
}