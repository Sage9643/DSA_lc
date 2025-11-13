class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> s=new Stack<>();

        for(int i=0;i<nums.length;i++){
            if(s.isEmpty() || nums[s.peek()]>=nums[i]) s.push(i);
        }
        int j=nums.length-1;int rampwidth=0;
        while(j>=0){
            while(!s.isEmpty() && nums[s.peek()]<=nums[j]){
                rampwidth=Math.max(rampwidth,j-s.peek());
                s.pop();
            }j--;
        }return rampwidth;
    }
}