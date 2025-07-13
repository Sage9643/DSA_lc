class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> lonely=new ArrayList<>();
        boolean result=false;
        Arrays.sort(nums);
        if(nums.length==1){
            lonely.add(nums[0]);
            return lonely;
        }else{
            for(int i=0;i<nums.length;i++){
            if(i==0){
                if(nums[1]!=nums[0]+1 && nums[1]!=nums[0]){
                    lonely.add(nums[0]);
                }
            }else if(i==nums.length-1){
                if(nums[nums.length-2]!=nums[nums.length-1]-1 && nums[nums.length-2]!=nums[nums.length-1]){
                    lonely.add(nums[i]);
                }
            }else{
                if(nums[i+1]!=nums[i]+1 && nums[i-1]!=nums[i]-1 && nums[i+1]!=nums[i] && nums[i-1]!=nums[i]){
                    lonely.add(nums[i]);
                }
            }
        }
        }
        return lonely;
    }
}