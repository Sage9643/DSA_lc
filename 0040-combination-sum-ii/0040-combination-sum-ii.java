class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>comb=new ArrayList<>();
        backtrack(ans,0,candidates,target,comb);
        return ans;
    }
    public static void backtrack(List<List<Integer>> ans,int idx,int[] candidates,int target,List<Integer> comb){
        if(target==0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;

            comb.add(candidates[i]);
            backtrack(ans,i+1,candidates,target-candidates[i],comb);
            comb.remove(comb.size()-1);
        }
    }
}