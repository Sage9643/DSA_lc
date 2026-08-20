class Solution {
    public int[] resultArray(int[] nums) {

        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();

        a1.add(nums[0]);
        a2.add(nums[1]);
        for(int i=2;i<nums.length;i++){
            if(a1.get(a1.size()-1)>a2.get(a2.size()-1)) a1.add(nums[i]);
            else a2.add(nums[i]);
        }
        int ans[]=new int[nums.length];
        int idx=0;
        for(int a:a1) ans[idx++]=a;
        for(int a:a2) ans[idx++]=a;

        return ans;

    }
}