class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=1000000007;
        for(int q[]:queries){
            int l=q[0];
            int r=q[1];
            int step=q[2];
            int mul=q[3];

            for(int i=l;i<=r;i+=step){
                nums[i]=(int)(((long)nums[i]*mul)%mod);
            }
        }int xor=0;
        for(int num:nums) xor^=num;

        return xor;
    }
}