class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(Integer num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> heap=new PriorityQueue<>();
        for(Integer key:map.keySet()){
            heap.add(new Pair(key,map.get(key)));
        }
        int arr[]=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=heap.remove().num;
        }return arr;
    }
}class Pair implements Comparable<Pair>{
    int num;
    int freq;
    public Pair(int num,int freq){
        this.num=num;
        this.freq=freq;
    }public int compareTo(Pair pair1){
        return pair1.freq-this.freq;
    }
}