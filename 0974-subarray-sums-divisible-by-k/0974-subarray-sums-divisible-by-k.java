class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        freq.put(0,1);
        int cnt=0;int prefixsum=0;

        for(int num:nums){
            prefixsum+=num;
            int mod=prefixsum%k;
            if(mod<0) mod+=k;

            if(freq.containsKey(mod)){
                cnt+=freq.get(mod);
            }
            freq.put(mod,freq.getOrDefault(mod,0)+1);
        }return cnt;

    }
}