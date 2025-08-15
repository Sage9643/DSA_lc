class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums)set.add(num);

        for(int i=0;i<moveTo.length;i++){
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int value:set) pq.add(value);

        List<Integer>ans=new ArrayList<>();
        int idx=0;

        while(!pq.isEmpty()){
            ans.add(pq.remove());
            idx++;
        }
        return ans;
    }
}