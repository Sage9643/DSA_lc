class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n==1 || n==2) return n;

        int lsb=0;
        for(int i=0;i<32;i++){
            int bitmask=1<<i;

            if((n & bitmask)>0) lsb=i+1;
        }
        return 1<<lsb;
    }
}