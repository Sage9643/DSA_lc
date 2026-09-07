class Solution {
    public int distinctSubseqII(String s) {
        long mod=1000000007;
        long ans=1;

        long dp[]=new long[26];

        for(char ch:s.toCharArray()){
            int idx=ch-'a';
            long add=ans;
            ans=(ans+add-dp[idx]+mod)%mod;
            dp[idx]=add;
        }
        return (int)((ans-1+mod)%mod);
    }
}