class Solution {
    public int longestBalanced(String s) {
        int maxlen=0;

        for(int i=0;i<s.length();i++){
            int freq[]=new int[26];
            for(int j=i;j<s.length();j++){
                freq[s.charAt(j)-'a']++;
                int cnt=freq[s.charAt(j)-'a'];
                boolean f=true;
                for(int k=0;k<26;k++){
                    
                    if(freq[k]!=0){
                        if(freq[k]!=cnt) {f=false;break;}
                    }
                }if(f) maxlen=Math.max(maxlen,j-i+1);
            }
        }return maxlen;
    }
}