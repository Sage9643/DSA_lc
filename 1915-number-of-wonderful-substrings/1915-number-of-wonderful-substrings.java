class Solution {
    public long wonderfulSubstrings(String word) {
        HashMap<Long,Long> map=new HashMap<>();
        map.put(0L,1L);

        long ans=0;
        long cummxor=0;

        for(char ch:word.toCharArray()){
            int shift=1<<(ch-'a');
            cummxor^=shift;

            ans+=map.getOrDefault(cummxor,0L);

            for(char c='a';c<='j';c++){
                int s=1<<(c-'a');
                long xor=cummxor^s;

                ans+=map.getOrDefault(xor,0L);
            }map.put(cummxor,map.getOrDefault(cummxor,0L)+1L);
        }
        return ans;

    }
}