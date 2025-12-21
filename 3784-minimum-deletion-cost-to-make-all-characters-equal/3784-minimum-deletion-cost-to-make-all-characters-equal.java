class Solution {
    public long minCost(String s, int[] cost) {
        long min=Long.MAX_VALUE;
        long tot=0;
        HashMap<Character,Long> map=new HashMap<>();

        int i=0;
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0L)+cost[i]);
            tot+=cost[i++];
        }
        for(char ch:map.keySet()){
            min=Math.min(min,tot-map.get(ch));
        }return min;
    }
}