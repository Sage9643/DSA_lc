class Solution {
    public int findKthNumber(int m, int n, int k) {
        int start=1,end=m*n;
        int ans=0;

        while(start<=end){
            int mid=(start+end)/2;

            if(count(mid,m,n)>=k){
                ans=mid;
                end=mid-1;
            }else start=mid+1;
        }
        return ans;
    }
    public static int count(int x,int m,int n){
        int cnt=0;

        for(int i=1;i<=m;i++) cnt+=Math.min(n,x/i);
        return cnt;
    }
}