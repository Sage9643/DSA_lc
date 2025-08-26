class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int i=0;i<deck.length;i++) freqMap.put(deck[i],freqMap.getOrDefault(deck[i],0)+1);

        int freqgcd=0;
        for(int freq:freqMap.values()){
            freqgcd=gcd(freqgcd,freq);
        }
        return freqgcd>1;
    }private int gcd(int freqgcd,int freq){
        if(freq==0) return freqgcd;
        return gcd(freq,freqgcd%freq);
    }
}