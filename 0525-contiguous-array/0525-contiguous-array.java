class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> sum= new HashMap<>();//contains sum and index
        sum.put(0,-1);
        int cumsum=0;
        int maxlength=0;
        for(int i=0;i<nums.length;i++){
            cumsum+=nums[i]==0?-1:1;
            if(sum.containsKey(cumsum)) maxlength=Math.max(maxlength,i-sum.get(cumsum));
            else sum.put(cumsum,i);
        }return maxlength;
    }//here we are using the target sum approach
}