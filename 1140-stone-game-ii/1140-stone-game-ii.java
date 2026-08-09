class Solution {
    public int stoneGameII(int[] piles) {
    
        int dp[][][]=new int[2][piles.length+1][piles.length+1];

        for(int dp1[][]:dp){
            for(int d[]:dp1) Arrays.fill(d,-1);
        }

        return rec(1,0,1,piles,dp);
        
    }
    public static int rec (int person,int idx,int m,int piles[],int dp[][][]){

        if(idx>=piles.length) return 0;
        int ans=person==1? Integer.MIN_VALUE:Integer.MAX_VALUE;
        int stones=0;

        if(dp[person][idx][m]!=-1) return dp[person][idx][m];

        for(int x=1;x<=Math.min(2*m,piles.length-idx);x++){
            stones+=piles[idx+x-1];

            if(person==1){
                ans=Math.max(ans,stones+rec(1-person,idx+x,Math.max(m,x),piles,dp));
            }
            else{
                ans=Math.min(ans,rec(1-person,idx+x,Math.max(m,x),piles,dp));
            }

        }
        return dp[person][idx][m]=ans;
    }
}