class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        HashSet<String> set=new HashSet<>();
        List<List<Integer>> ans=new ArrayList<>();

        heap.add(new int[]{nums1[0]+nums2[0],0,0});
        set.add("0,0");

        while(k!=0){
            k--;
            int rem[]=heap.remove();
            ans.add(Arrays.asList(nums1[rem[1]],nums2[rem[2]]));
            set.add(rem[1]+","+rem[2]);

            if(rem[1]+1<nums1.length && !set.contains((rem[1]+1)+","+rem[2])){
                heap.add(new int[]{nums1[rem[1]+1]+nums2[rem[2]],rem[1]+1,rem[2]});
                set.add((rem[1]+1)+","+rem[2]);

            }if(rem[2]+1<nums2.length && !set.contains(rem[1]+","+(rem[2]+1))){
                heap.add(new int[]{nums1[rem[1]]+nums2[rem[2]+1],rem[1],rem[2]+1});
                set.add(rem[1]+","+(rem[2]+1));

            }
        }return ans;

    }
}