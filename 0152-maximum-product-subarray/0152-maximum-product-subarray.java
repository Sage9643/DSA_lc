class Solution {
    public int maxProduct(int[] nums) {

        HashSet<Integer> prev=new HashSet<>();
        int max=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            HashSet<Integer> curr=new HashSet<>();
            curr.add(nums[i]);
            max=Math.max(nums[i],max);
            for(int j : prev){
                curr.add(nums[i]*j);
                max=Math.max(nums[i]*j,max);
            }prev=curr;
        }
        return max;
    }
}