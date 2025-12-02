class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] p:points)
            map.put(p[1],map.getOrDefault(p[1],0)+1);

        ArrayList<Long> seg=new ArrayList<>();
        for(int y:map.keySet()){
            int cnt=map.get(y);
            if(cnt>=2) seg.add((long)cnt*(cnt-1)/2);
        }
        long mod=1000000007;
        long tot=0,sqsum=0,sum=0;

        for(int i= 0;i<seg.size();i++){
            long val=seg.get(i);
            sum=(sum+val)%mod;
            sqsum=((sqsum%mod)+(val*val)%mod)%mod;
        }long inv2=(mod+1)/2;
        tot=((((sum*sum)%mod-sqsum+mod)%mod)*inv2)%mod;

        return (int)tot;
    }
}
