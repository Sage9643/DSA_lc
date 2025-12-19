class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxh=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return b[0]-a[0];
        });
        PriorityQueue<int[]> minh=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int i=0,j=0;

        int maxlen=0;
        while(j<nums.length){
            maxh.add(new int[]{nums[j],j});
            minh.add(new int[]{nums[j],j});
            while(!maxh.isEmpty() && !minh.isEmpty() && Math.abs(minh.peek()[0]-maxh.peek()[0])>limit){
            
                int idx=Math.min(minh.peek()[1],maxh.peek()[1]);
                i=idx+1;
               
                while(!maxh.isEmpty() && maxh.peek()[1]<i) maxh.remove();
                while(!minh.isEmpty() && minh.peek()[1]<i) minh.remove();
                
                
            }maxlen=Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;

    }
}