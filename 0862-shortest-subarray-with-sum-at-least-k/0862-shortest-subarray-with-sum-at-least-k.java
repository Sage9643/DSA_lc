class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int size=Integer.MAX_VALUE;
        int j=0;

        long prefsum[]=new long[nums.length];
        Deque<Integer> dq=new ArrayDeque<>();

        while(j<nums.length){
            prefsum[j]=j==0?nums[j]: prefsum[j-1]+nums[j];

            long curr=prefsum[j];

            if(curr>=k){
                size=Math.min(size,j+1);     
            }

            
            while(!dq.isEmpty() && curr-prefsum[dq.peekFirst()]>=k){
                size=Math.min(size,j-dq.peekFirst());
                dq.removeFirst();
            }

            while(!dq.isEmpty() && prefsum[dq.peekLast()]>=curr) dq.removeLast();
            dq.addLast(j);
            j++;
        }
        if(size==Integer.MAX_VALUE) return -1;

        return size;
    }
}