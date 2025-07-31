class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        HashSet<Integer> resultset=new HashSet<>();
        HashSet<Integer> prevset=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){

            HashSet<Integer> currset=new HashSet<>();
            currset.add(nums[i]);

            for(int j : prevset){
                currset.add(j | nums[i]);
            }resultset.addAll(currset);
            prevset=currset;
        }
        return resultset.size();
    }
}