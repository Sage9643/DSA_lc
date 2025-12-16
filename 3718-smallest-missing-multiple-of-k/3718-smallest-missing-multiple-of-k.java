class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);

        for(int i=1;i<=Integer.MAX_VALUE;i++){
            if(!set.contains(k*i)) return k*i;
        }return -1;
    }
}