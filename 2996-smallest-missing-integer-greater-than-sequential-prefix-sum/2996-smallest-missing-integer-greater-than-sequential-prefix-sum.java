class Solution {
    public int missingInteger(int[] nums) {

        int sum=nums[0];

        for(int j=1;j<nums.length;j++){
            if(nums[j-1]!=nums[j]-1){
                break;
            }
            sum+=nums[j];    
        }
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);
        while(true){
            if(!set.contains(sum)){
                break;
            }else sum++;
        }
        return sum;

    }
}