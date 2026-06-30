class Solution {
    public int numberOfSubstrings(String s) {
        int cnt=0,cnta=0,cntb=0,cntc=0;

        int i=0,j=0;

        while(j<s.length()){
            if(s.charAt(j)=='a') cnta++;
            else if(s.charAt(j)=='b') cntb++;
            else cntc++;

            while(cnta>0 && cntb>0 && cntc>0){
                cnt+=s.length()-j;
                if(s.charAt(i)=='a') cnta--;
                else if(s.charAt(i)=='b') cntb--;
                else cntc--;
                i++;

            }j++;
        }return cnt;
    }
}