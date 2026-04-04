class Solution {
    public int longestSubsequence(String s, int k) {
        int zero=0;int cnt=0;
        double val=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0')zero++;
            else{
                double v=val+Math.pow(2,(s.length()-1-i));
                if(v<=k){
                    val=v;
                    cnt++;
                }
            }
        }return zero+cnt;
    }
}