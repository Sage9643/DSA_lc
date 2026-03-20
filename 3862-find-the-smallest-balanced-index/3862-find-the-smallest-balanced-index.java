class Solution {
    public int smallestBalancedIndex(int[] nums) {
        double l[]=new double[nums.length];
        double r[]=new double[nums.length];

        l[0]=0;
        r[r.length-1]=1;

        for(int i=1;i<l.length;i++){
            l[i]=(double)l[i-1]+nums[i-1];
            r[r.length-1-i]=(double)nums[r.length-i]*r[r.length-i];
        }for(int i=0;i<nums.length;i++){
            if(l[i]==r[i]) return i;
        }
        return -1;
    }
}