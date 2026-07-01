class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums) pq.add(num);

        while(k>0){
            int el=pq.remove();
            pq.add(el+1);
            k--;
        }
        double ans=1;

        while(!pq.isEmpty()) ans=(ans*pq.remove())%1000000007;
        return (int)(ans%1000000007);
    }
}