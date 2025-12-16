class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        long m=0;boolean f=false;
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums1) set.add(n);
        
        for(int i=0;i<nums1.length;i++) {
            m+=Math.abs(nums1[i]-nums2[i]);set.add(nums2[i]);
            if((nums2[nums2.length-1]<=nums1[i] && nums2[nums2.length-1]>=nums2[i])|| (nums2[nums2.length-1]>=nums1[i] && nums2[nums2.length-1]<=nums2[i])) f=true;
        }

        
        int k=0;
        while(!f){
            if(!f && set.contains(nums2[nums2.length-1]+k)) {m+=k; f=true;}
            if(!f && set.contains(nums2[nums2.length-1]-k)) {m+=k; f=true;}
            k++;
        }
        return m+1;
    }
}