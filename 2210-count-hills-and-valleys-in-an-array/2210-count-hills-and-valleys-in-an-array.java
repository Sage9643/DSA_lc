class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        Stack<Integer> s=new Stack<>();
        s.add(nums[0]);
        for(int i=0;i<nums.length-1;i++){
            if(!s.isEmpty() && nums[i]==s.peek()){
                while(!s.isEmpty() && nums[i]==s.peek()){
                    s.pop();
                }
            }if(!s.isEmpty() &&((s.peek()<nums[i] && nums[i+1]<nums[i])||(s.peek()>nums[i] && nums[i+1]>nums[i]))){
                count++;
            }s.push(nums[i]);
        }return count;
    }
}