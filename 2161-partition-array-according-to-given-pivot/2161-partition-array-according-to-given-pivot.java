class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> small=new ArrayList<>();
        ArrayList<Integer> equal=new ArrayList<>();
        ArrayList<Integer> greater=new ArrayList<>();

        for(int num:nums){
            if(num<pivot) small.add(num);
            else if(num==pivot) equal.add(num);
            else greater.add(num);
        }
        int ans[]=new int[nums.length];
        int idx=0;

        for(int num:small){
            ans[idx++]=num;
        }for(int num:equal){
            ans[idx++]=num;
        }for(int num:greater){
            ans[idx++]=num;
        }
        return ans;
    }
}