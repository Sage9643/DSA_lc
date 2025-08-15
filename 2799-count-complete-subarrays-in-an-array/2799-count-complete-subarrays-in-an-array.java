class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);

        int uniq=set.size();
        int i=0;
        int count=0;
        while(i<nums.length){
            int j=i;
            HashSet<Integer> subset=new HashSet<>();
            while(j<nums.length){
                subset.add(nums[j]);
                if(subset.size()==uniq) count++;
                j++;
            }i++;
        }
        return count;
    }
}