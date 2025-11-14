class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum=0;int ans[]=new int[queries.length];int i=0;
        for(int num:nums){
            if(num%2==0) sum+=num;
        }for(int query[]:queries){
            int idx=query[1];
            int val=query[0];

            if(nums[idx]%2==0){
                if(val%2==0) sum+=val;
                else sum-=nums[idx];
            }
            else{
                if(val%2!=0) sum+=(nums[idx]+val);
            }nums[idx]+=val;ans[i++]=sum;
        }return ans;
    }
}