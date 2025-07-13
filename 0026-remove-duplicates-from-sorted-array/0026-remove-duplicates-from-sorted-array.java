class Solution {
    public int removeDuplicates(int[] nums) {
        int nondup=-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nondup++;
                nums[nondup]=nums[i];
            }
        }nondup++;
        nums[nondup]=nums[nums.length-1];
        return nondup+1;
    }
        /*int unique=0;
        ArrayList<Integer> num=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                unique++;
                num.add(nums[i]);
            }
        }num.add(nums[nums.length-1]);
        for(int i=0;i<num.size();i++){
            nums[i]=num.get(i);
        }return unique+1;
        */
    
}