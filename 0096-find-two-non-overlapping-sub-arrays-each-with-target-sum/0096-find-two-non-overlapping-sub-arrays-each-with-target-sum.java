class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;

        int pref[]=new int[n];
        Arrays.fill(pref,Integer.MAX_VALUE);

        int ans=Integer.MAX_VALUE;
        int l=0,sum=0;

        for(int r=0;r<n;r++){
            sum+=arr[r];

            while(sum>target){
                sum-=arr[l++];
            }
            if(sum==target){
                int len=r-l+1;
                if (l>0 && pref[l-1]!=Integer.MAX_VALUE) ans=Math.min(ans,len+pref[l-1]);
                pref[r] = len;
            }
            if(r>0) pref[r]=Math.min(pref[r],pref[r-1]);
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}