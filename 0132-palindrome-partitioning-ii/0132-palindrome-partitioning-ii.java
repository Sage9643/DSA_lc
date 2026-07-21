class Solution {
    public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n];

        Arrays.fill(dp,-1);

        return memo(s,0,n,dp)-1;

    }
    public static int memo(String s,int idx,int n,int dp[]){
        if(idx==n) return 0;

        if(dp[idx]!=-1) return dp[idx];
        int minpart=Integer.MAX_VALUE;

        for(int j=idx;j<n;j++){
            if(isPalindrome(idx,j,s)){
                int part=1+memo(s,j+1,n,dp);
                minpart=Math.min(part,minpart);
            }
        }
        return dp[idx]=minpart;


    }public static boolean isPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}