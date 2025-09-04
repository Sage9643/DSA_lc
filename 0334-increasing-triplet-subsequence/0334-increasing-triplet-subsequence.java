class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n1=Integer.MAX_VALUE;
        int n2=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            int n3=nums[i];

            if(n3<=n1) n1=n3;
            else if(n3<=n2) n2=n3;
            else return true;
        }return false;
    }
}