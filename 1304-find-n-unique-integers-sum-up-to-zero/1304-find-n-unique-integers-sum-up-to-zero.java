class Solution {
    public int[] sumZero(int n) {
        int ans[]=new int[n];

        if (n%2!=0) ans[n-1]=0;

        int idx=0;
        for(int i=1;i<n/2+1;i++){
            ans[idx++]=i;
            ans[idx++]=-i;
        }return ans;
    }
}