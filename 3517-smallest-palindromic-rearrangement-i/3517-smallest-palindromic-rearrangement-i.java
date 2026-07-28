class Solution {
    public String smallestPalindrome(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()) freq[ch-'a']++;

        char str[]=new char[s.length()];
        char ch='a';


        for(int i=0;i<freq.length;i++){
            if(freq[i]>1){
                ch=(char)('a'+i);
                break;
            }
        }
        for(int i=0;i<s.length()/2;i++){
            str[i]=ch;str[str.length-1-i]=ch;

            freq[ch-'a']-=2;
            if(freq[ch-'a']<2){
                int idx=ch-'a';

                for(int k=idx;k<freq.length;k++){
                    if(freq[k]>1) {
                        ch=(char)('a'+k);
                        break;
                    }
                }
            }
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]==1){
                str[str.length/2]=(char)('a'+i);
                break;
            }
        }
        String ans=new String(str);
        return ans;
    }
    
}