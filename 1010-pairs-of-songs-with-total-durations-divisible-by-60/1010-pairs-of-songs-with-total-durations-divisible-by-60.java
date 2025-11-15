class Solution {
    public int numPairsDivisibleBy60(int[] times) {
        HashMap<Integer,Integer> map=new HashMap<>(); 
        int cnt=0;

        for(int time :times){
            int rem=time%60;
            int partner=(60-rem)%60;
            if(map.containsKey(partner)) cnt+=map.get(partner);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }return cnt;
    }
}