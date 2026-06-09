class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> set=new ArrayList<>();

        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                int bitmask=1<<j;
                if((i & bitmask)!=0) l.add(nums[j]);
            }set.add(l);
        }
        int sum=0;
        for(List<Integer> l:set){
            int xor=0;
            for(int i=0;i<l.size();i++) xor^=l.get(i);
            sum+=xor;
        }
        return sum;
    }
}