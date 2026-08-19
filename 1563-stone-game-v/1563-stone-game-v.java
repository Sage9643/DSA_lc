class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int prefsum[]=new int[n];
        prefsum[0]=stoneValue[0];

        int dp[][]=new int[n][n];
        for(int d[]:dp) Arrays.fill(d,-1);

        for(int i=1;i<n;i++) prefsum[i]=stoneValue[i]+prefsum[i-1];

        return rec(0,n-1,prefsum,dp);
    }
    public static int rec(int l,int r,int prefsum[],int dp[][]){
        if(l>=r) return dp[l][r]=0;

        int score=0;

        if(dp[l][r]!=-1) return dp[l][r];

        for(int i=l;i<r;i++){
            int lsum=prefsum[i];
            if(l>0) lsum-=prefsum[l-1];
            int rsum=prefsum[r]-prefsum[i];

            if(lsum>rsum){
                score=Math.max(score,rsum+rec(i+1,r,prefsum,dp));
            }else if(lsum<rsum) score=Math.max(score, lsum+rec(l,i,prefsum,dp));

            else score=Math.max(score,Math.max(rsum+rec(i+1,r,prefsum,dp),lsum+rec(l,i,prefsum,dp)));
        }
        return dp[l][r]=score;
    }
}