class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()) freq[ch-'a']++;

        for(int i=target.length()-1;i>=0;i--){
            int x=target.charAt(i)-'a';

            int rem[]=freq.clone();

            for (int k = 0; k < i; k++) {
                int ch=target.charAt(k)-'a';
                rem[ch]--;
                if (rem[ch]<0) {
                    rem=null;
                    break;
                }
            }
            if(rem==null) continue;

            for(int j=x+1;j<26;j++){
                if (rem[j]>0){
                    rem[j]--;

                    StringBuilder ans=new StringBuilder(target.substring(0,i));
                    ans.append((char)('a'+j));

                    for(int k=0;k<26;k++)
                        while (rem[k]-->0)
                            ans.append((char)('a'+k));

                    return ans.toString();
                }
            }
        }

        return "";
    }
}