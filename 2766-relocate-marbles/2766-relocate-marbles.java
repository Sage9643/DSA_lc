class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums)set.add(num);

        for(int i=0;i<moveTo.length;i++){
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer>ans=new ArrayList<>();
        int idx=0;

        for(int num:set){
            ans.add(num);
            idx++;
        }Collections.sort(ans);
        return ans;
    }
}