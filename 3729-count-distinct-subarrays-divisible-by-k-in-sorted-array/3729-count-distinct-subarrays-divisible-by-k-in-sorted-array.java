class Solution {
    public long numGoodSubarrays(int[] nums, int k) {
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        Long sum=0L;long totcnt=0;

        for(int num:nums){
            sum+=num;
            long r=((sum%k)+k)%k;
            totcnt+=map.getOrDefault(r,0);
            map.put(r,map.getOrDefault(r,0)+1);
        }
        int i=0;long duplicates=0;
        while(i<nums.length){
            int j=i;
            while(j<nums.length){
                if(nums[i]==nums[j])j++;
                else break;
            }int n=nums[i];
            for(int h=1;h<=j-i;h++){
                long s=1L*n*h;
                if(s%k==0){
                    duplicates+=(j-i)-h;
                }
            }i=j;
        }return totcnt-duplicates;
    }
}