class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a:arr) map.put(a,map.getOrDefault(a,0)+1);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });

        for(int key:map.keySet()) pq.add(new int[]{key,map.get(key)});
        int cnt=pq.size();

        while(k>0 && !pq.isEmpty()){
            int a[]=pq.remove();
            if(k<a[1]) return cnt;
            else{
                cnt--;k-=a[1];
            }
        }return cnt;
    }
}