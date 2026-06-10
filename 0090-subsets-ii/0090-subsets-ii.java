class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<ArrayList<Integer>> set=new HashSet<>();

        for(int i=0;i<(1<<nums.length);i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                int bitmask=1<<j;

                if((i & bitmask)!=0) arr.add(nums[j]);
            }if(!set.contains(arr)){
                ans.add(arr);
                set.add(arr);
            }
        }return ans;
    }
}