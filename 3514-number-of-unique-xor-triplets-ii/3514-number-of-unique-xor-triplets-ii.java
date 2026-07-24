class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        HashSet<Integer> xors=new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                xors.add(nums[i]^nums[j]);
            }
        }
        HashSet<Integer> uniqXors=new HashSet<>();
        for(int x:xors){
            for(int num:nums) uniqXors.add(num^x);
        }
        return uniqXors.size();

    }
}