class Solution {
    public int countPairs(int[] deliciousness) {
        HashMap<Long,Integer> map=new HashMap<>();
        HashSet<Long> set=new HashSet<>();
        long mod=1000000007;
        long pow=1;
        int i=0;
        while(i<22){
            set.add(pow);
            pow*=2;
            i++;
        }
        long pairs=0;

        for(int j=0;j<deliciousness.length;j++){
            long num=deliciousness[j];
            for(Long p:set){
                if(map.containsKey((long)p-num)) pairs=(pairs+map.get((long)p-num))%mod;
            }map.put(num,map.getOrDefault(num,0)+1);
        }
        return (int)pairs;
    }
}