class Solution {
    HashMap<Integer,List<Integer>> map=new HashMap<>();
    public Solution(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                List<Integer> index=new ArrayList<>();
                index.add(i);
                map.put(nums[i],index);
            }else{
                map.get(nums[i]).add(i);
            }

        }
    }
    
    public int pick(int target){
        List<Integer> targetNum=map.get(target);
        Random idx=new Random();
        int randomIdx=idx.nextInt(targetNum.size());
        return targetNum.get(randomIdx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */