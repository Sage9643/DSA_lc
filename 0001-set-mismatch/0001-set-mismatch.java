class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int rep=0;

        for(int num:nums){
            if(set.contains(num)) rep=num;
            set.add(num);
        }int ans[]=new int[2];
        ans[0]=rep;
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                ans[1]=i;
                break;
            }
        }return ans;
    }
}