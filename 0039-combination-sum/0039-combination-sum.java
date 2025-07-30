class Solution {
    static HashSet<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        set.clear();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> combinations=new ArrayList<>();
        combination(candidates,0,target,combinations,ans);
        return ans;
    }
    public static void combination(int arr[],int idx,int target,List<Integer>combinations,List<List<Integer>> ans){
        if(idx==arr.length || target<0){
            return;
        }if(target==0){
            if(!set.contains(combinations)){
                ans.add(new ArrayList<>(combinations));
                set.add(new ArrayList<>(combinations));
                return;
            }
            
        }
        combinations.add(arr[idx]);
        combination(arr,idx+1,target-arr[idx],combinations,ans);//single time include
        combination(arr,idx,target-arr[idx],combinations,ans);//multiple times include
        combinations.remove(combinations.size()-1);
        combination(arr,idx+1,target,combinations,ans);//not including element


    }
}