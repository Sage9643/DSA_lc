class Solution {
    public int findMinFibonacciNumbers(int k) {
        Long a=1L,b=1L;
        PriorityQueue<Long> pq=new PriorityQueue<>((x,y)->Long.compare(y,x));
        pq.add(1L);
        int steps=0;

        Long c=a+b;
        while(c<=k){
            pq.add(c);
            a=b;b=c;c=a+b;
        }
        Long sum=0L;
        while(!pq.isEmpty() && sum!=k){
            Long s=pq.remove();
            if((sum+s)<=k){sum+=s;steps++;}
            if(k-sum>=s) pq.add(s);    
        }return steps;
    }
}