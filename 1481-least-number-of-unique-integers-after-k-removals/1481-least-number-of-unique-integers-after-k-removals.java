class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a:arr) map.put(a,map.getOrDefault(a,0)+1);

        int freq[]=new int[arr.length+1];

        for(int v:map.keySet()){
            freq[map.get(v)]++;
        }
        int cnt=map.size();

        for(int i=1;i<freq.length;i++){
            if(freq[i]!=0){
                if(k>=freq[i]*i){
                    k-=freq[i]*i;
                    cnt-=freq[i];
                }
                else return cnt-(k/i);
            }
        }return cnt;
        
    }
}