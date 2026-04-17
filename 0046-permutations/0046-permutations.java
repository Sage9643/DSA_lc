class Solution {
    static List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        backtrack(nums,new HashSet(),new ArrayList<>());
        return ans;
    }
    public static void backtrack(int nums[],HashSet<Integer> set,ArrayList<Integer> arr){
        if(nums.length==arr.size()) {ans.add(new ArrayList<>(arr));return;}

        for(int i=0;i<nums.length;i++){
            if(set.contains(i)) continue;
            set.add(i);
            arr.add(nums[i]);
            backtrack(nums,set,arr);
            set.remove(i);
            arr.remove(arr.size()-1);
        }
    }
}