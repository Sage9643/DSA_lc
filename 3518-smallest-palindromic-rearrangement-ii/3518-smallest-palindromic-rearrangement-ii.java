class Solution {
    public String smallestPalindrome(String s, int k) {
        int freq[]=new int[26];
        StringBuilder odd=new StringBuilder();
        int n=s.length();
        int halffreq[]=new int[26];
        int cap=k+1;
        int m=n/2;

        for(char ch:s.toCharArray()) freq[ch-'a']++;

        for(int i=0;i<26;i++){
            halffreq[i]=freq[i]/2;
            if(freq[i]%2!=0) odd.append((char)('a'+i));
        }

        long total=countPermutations(halffreq,m,cap);
        if(total<k) return "";
        int remk=k;

        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<n/2;i++){
            for(int j=0;j<26;j++){
                if(halffreq[j]!=0){

                    char ch=(char)('a'+j);
                    halffreq[j]--;
                    long f=countPermutations(halffreq,m-i-1,cap);

                    if(f<remk){
                        remk-=(int)f;
                        halffreq[j]++;
                    
                    }else{
                        sb.append(ch);
                        
                        break;
                    }
                }
            }
        }if(odd.length()>0) sb.append(odd);

        for(int i=(n/2)-1;i>=0;i--) sb.append(sb.charAt(i));
        return sb.toString();
    }

    public static long nCr(int n,int r,int cap){
        r=Math.min(r,n-r);
        long ans=1;
        for(int i=1;i<=r;i++){
            ans=ans*(n-r+i)/i;
            if(ans>cap) return cap;
        }
        return ans;
    }

    public long countPermutations(int[] counts,int totalCount,int cap) {
        long res=1;
        int remaining=totalCount;
        for (int i=0;i<26;i++) {
            int c=counts[i];

            if (c==0) continue;

            long comb=nCr(remaining,c,cap);
            res*=comb;

            if(res>cap) return cap;
            remaining-=c;
        }
        return res;
    }
}