class Solution {
    public int[] numMovesStonesII(int[] stones) {
        
        int n=stones.length;
        
        Arrays.sort(stones);
        int minmoves=Integer.MAX_VALUE;

        int i=0,j=0;

        while(j<n){
            while(i<n && j<n && stones[j]-stones[i]>=n) i++;
            if(j==n) break;
            

            if (j-i+1==n-1 && stones[j]-stones[i]+1==n-1) {

                minmoves=Math.min(minmoves, 2);
            }else minmoves=Math.min(minmoves,n-(j-i+1));

            j++;
        }
        

        int diff1=0;
        for(i=0;i<n-2;i++) diff1+=stones[i+1]-stones[i]-1;
        
        int diff2=0;
        for(i=1;i<n-1;i++) diff2+=stones[i+1]-stones[i]-1;

        int maxmoves=Math.max(diff1,diff2);

        int ans[]={minmoves,maxmoves};

        return ans;    

    }
}