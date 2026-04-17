class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] vis=new boolean[nums.length];

        backtrack(nums,vis,new ArrayList<>(),ans);
        HashSet<List<Integer>> set=new HashSet<>(ans);
        ans=new ArrayList<>(set);

        return ans;
    }
    public static void backtrack(int nums[],boolean[] vis,List<Integer> arr,List<List<Integer>> ans){
        if(nums.length==arr.size()){ans.add(new ArrayList<>(arr));return;}

        for(int i=0;i<nums.length;i++){
            if(vis[i]) continue;
            vis[i]=true;
            arr.add(nums[i]);
            backtrack(nums,vis,arr,ans);
            vis[i]=false;
            arr.remove(arr.size()-1);
        }

    }
}