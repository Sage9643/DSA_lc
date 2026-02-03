class Solution {
    public boolean isTrionic(int[] nums) {
        boolean inc=false;
        boolean dec=false;
        boolean inc2=false;
        int i=0;

        while(i<nums.length-1 && nums[i]<nums[i+1]) {i++;inc=true;}

        while(i<nums.length-1 && nums[i]>nums[i+1]) {i++;dec=true;}
        while(i<nums.length-1 && nums[i]<nums[i+1]) {i++;inc2=true;}

        return inc&& dec&& inc2 && i==nums.length-1;
        
        
        
    }
}