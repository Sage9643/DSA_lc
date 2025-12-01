class Solution {
    public int findBestValue(int[] arr, int target) {
        int start=0,end=0;
        for(int num:arr) end=Math.max(end,num);

        int best=end;
        int bestDiff=Integer.MAX_VALUE;

        while(start<=end) {
            int mid=start+(end-start)/2;
            int sum=0;
            for (int num:arr) sum+=Math.min(num,mid);

            int diff=Math.abs(sum-target);

            if(diff<bestDiff || (diff==bestDiff && mid<best)) {
                bestDiff=diff;
                best=mid;
            }if(sum<target) {
                start=mid+1;
            }else end=mid-1;
            
        }

        return best;
    }
}
