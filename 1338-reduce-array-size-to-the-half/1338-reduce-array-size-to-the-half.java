class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr) map.put(num,map.getOrDefault(num,0)+1);

        int [][] a=new int[map.size()][2];
        int i=0;
        for(int key:map.keySet()) a[i++]=new int[]{key,map.get(key)};

        Arrays.sort(a,(c,b)->{
            return b[1]-c[1];
        });
        int cnt=0,freq=0;

        for(int num[]:a){
            cnt+=num[1];freq++;
            if(cnt>=(arr.length/2)) return freq;
        }
        return freq;
    }
}