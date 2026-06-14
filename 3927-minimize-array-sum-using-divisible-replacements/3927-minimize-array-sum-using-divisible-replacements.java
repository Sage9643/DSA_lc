class Solution {
    public long minArraySum(int[] nums) {
        long sum=0;
        int max=0;
        TreeMap<Integer,Integer> map=new TreeMap<>();

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
            max=Math.max(max,n);
        }
        for(int k:map.keySet()){
            if(map.get(k)==0) continue;

            for(int i=k;i<=max;i+=k){
                if(map.containsKey(i)){
                    sum+=((long)k*map.get(i));
                    map.put(i,0);
                }
            }
        }
        return sum;
    }
}