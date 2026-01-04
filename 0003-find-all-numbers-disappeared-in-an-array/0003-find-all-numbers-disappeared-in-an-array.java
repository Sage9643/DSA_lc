class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);

        List<Integer> l=new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i))l.add(i);
        }return l;
    }
}