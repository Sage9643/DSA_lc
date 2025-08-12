class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> freqMap=new HashMap<>();
        for(String str:words){
            freqMap.put(str,freqMap.getOrDefault(str,0)+1);
        }
        PriorityQueue<Pair> frequency=new PriorityQueue<>();
        for(String key:freqMap.keySet()){
            frequency.add(new Pair(key,freqMap.get(key)));
        }
        List<String> kFrequent=new ArrayList<>();
        for(int i=0;i<k;i++){
            Pair element=frequency.remove();
            kFrequent.add(element.str);
        }return kFrequent;
    }
}class Pair implements Comparable<Pair>{
    String str;
    int freq;
    public Pair(String str,int freq){
        this.str=str;
        this.freq=freq;
    }public int compareTo(Pair pair2){
        if(this.freq==pair2.freq) return this.str.compareTo(pair2.str);
        return pair2.freq-this.freq; 
    }
}