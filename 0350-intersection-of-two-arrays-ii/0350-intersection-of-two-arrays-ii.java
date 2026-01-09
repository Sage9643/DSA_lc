class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums1) map.put(num,map.getOrDefault(num,0)+1);
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num)) {
                arr.add(num);
                map.put(num,map.get(num)-1);
                if(map.get(num)==0) map.remove(num);
            }
        }
        int ans[]=new int[arr.size()];
        int i=0;
        for(int a:arr) ans[i++]=a;

        return ans;
    }
}