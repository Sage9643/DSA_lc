class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        Arrays.sort(hand);
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int hands:hand) freqMap.put(hands,freqMap.getOrDefault(hands,0)+1);

        for(int hands:hand){
            if(freqMap.get(hands)!=0){
                for(int i=hands;i<hands+groupSize;i++){
                    if(freqMap.get(i)==null || freqMap.get(i)==0) return false;
                    freqMap.put(i,freqMap.get(i)-1);
                }
            }
        }return true;
    }
}