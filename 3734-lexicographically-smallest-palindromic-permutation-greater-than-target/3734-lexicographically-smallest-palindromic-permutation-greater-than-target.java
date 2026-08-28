class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length();
        int freq[]=new int[26];

        for(char ch:s.toCharArray()) freq[ch-'a']++;

        int odd=0, mid=-1;

        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                odd++;
                mid=i;
            }
        }if(odd>1) return "";

        int pair[]=new int[26];

        for(int i=0;i<26;i++) pair[i]=freq[i]/2;

        int half=n/2;

        int rem[]=pair.clone();
        StringBuilder left=new StringBuilder();
        boolean possible=true;

        for(int i=0;i<half;i++){
            int x=target.charAt(i)-'a';

            if(rem[x]==0){
                possible=false;
                break;
            }
            rem[x]--;
            left.append((char)('a'+x));
        }
        if(possible){
            StringBuilder ans=new StringBuilder(left);

            if(n%2==1)
                ans.append((char)('a'+mid));

            for(int i=half-1;i>=0;i--)
                ans.append(left.charAt(i));

            
            if(ans.toString().compareTo(target)>0)
                return ans.toString();
        }
        for(int i=half-1;i>=0;i--){
            rem=pair.clone();
            boolean ok = true;

            for(int j=0;j<i;j++){
                int x=target.charAt(j)-'a';

                if(rem[x]==0){
                    ok=false;
                    break;
                }rem[x]--;
            }if(!ok) continue;

            int x=target.charAt(i)-'a';
            for(int j=x+1;j<26;j++){
                if (rem[j]==0) continue;
                rem[j]--;

                left=new StringBuilder(target.substring(0, i));

                left.append((char)('a'+j));
            
                for(int k=0;k<26;k++){
                    while(rem[k]>0){
                        left.append((char)('a'+k));
                        rem[k]--;
                    }
                }
                StringBuilder ans=new StringBuilder(left);
                if(n%2==1) ans.append((char)('a'+mid));

                for(int k=half-1;k>=0;k--) ans.append(left.charAt(k));

                return ans.toString();
            }
        }
        rem=pair.clone();
        left=new StringBuilder();

        for (int i=0;i<half;i++){
            int x=target.charAt(i)-'a';

            if(rem[x]==0) return "";
            rem[x]--;
            left.append((char)('a'+x));
        }
        StringBuilder ans=new StringBuilder(left);
        if (n%2==1) ans.append((char)('a'+mid));

        for(int i=half-1;i>=0;i--) ans.append(left.charAt(i));

        String str=ans.toString();

        if(str.compareTo(target)>0) return str;

        return "";
    }
}