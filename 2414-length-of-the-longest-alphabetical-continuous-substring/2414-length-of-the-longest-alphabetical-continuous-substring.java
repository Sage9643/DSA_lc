class Solution {
    public int longestContinuousSubstring(String s) {
        char curr=s.charAt(0);
        int len=1;
        int maxlen=0;

        for(int i=1;i<s.length();i++){
            char next=(char)(curr+1);
            if(next!=s.charAt(i)){
                maxlen=Math.max(maxlen,len);
                len=0;
            }len++;
            curr=s.charAt(i);
        }maxlen=Math.max(maxlen,len);
        return maxlen;
    }
}