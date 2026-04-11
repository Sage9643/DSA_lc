class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++) prefix[i]=prefix[i-1]^arr[i];

        int ans[]=new int[queries.length];
        int idx=0;
        for(int q[]:queries){
            if(q[0]>0)ans[idx++]=prefix[q[1]]^prefix[q[0]-1];
            else ans[idx++]=prefix[q[1]];
        }
        return ans;
    }
}