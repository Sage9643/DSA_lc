class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums1) set.add(num);
        HashSet<Integer> arr=new HashSet<>();
        for(int num:nums2){
            if(set.contains(num)) arr.add(num);
        }
        int ans[]=new int[arr.size()];
        int i=0;
        for(int a:arr) ans[i++]=a;

        return ans;
    }
}