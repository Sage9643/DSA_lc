class Solution {
    public long putMarbles(int[] weights, int k) {
        if(weights.length==k) return 0;

        PriorityQueue<Long> pqmax=new PriorityQueue<>((a,b)->Long.compare(b,a));
        PriorityQueue<Long> pqmin=new PriorityQueue<>();

        long ans=0;
        k--;

        for(int i=0;i<weights.length-1;i++){
            long sum=weights[i]+weights[i+1];
            pqmax.add(sum);
            pqmin.add(sum);
        }
        while(k>0){
            long max=pqmax.remove();
            long min=pqmin.remove();
            ans+=(max-min);
            k--;
        }
        return ans;
    }
}