class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<(1<<nums.length);i++){//iterating through all the numbers in bit format
            List<Integer> list=new ArrayList<>();
            int j=0;//index of bits of numbers
            while(j<nums.length){//bits of use of a number will be equal to elements of list
                if(((i) & (1<<j))>0){//checking if bit at jth index id one or not
                    list.add(nums[j]);//if one that means the element should be added
                }j++;
            }result.add(list);
        }return result;
    }
}