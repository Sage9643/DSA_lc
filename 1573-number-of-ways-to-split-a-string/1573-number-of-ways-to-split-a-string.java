class Solution {
    public int numWays(String s) {
        int ones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') ones++; 
        }if(ones%3!=0) return 0;
        if(ones==0){ 
            long n=s.length();
            return (int)(((n-1)*(n-2)/2)%1000000007);
        }

        int each=ones/3;

        long firstbreak=0,secondbreak=0;
        int cnt1=0,cnt2=0;

        int i=0;
        for(;i<s.length();i++){
            if(s.charAt(i)=='1')cnt1++;
            if(cnt1==each) break;
        }i++;
        while(i<s.length() && s.charAt(i)!='1'){
            firstbreak++;
            i++;
        }
        for(;i<s.length();i++){
            if(s.charAt(i)=='1')cnt2++;
            if(cnt2==each) break;
        }i++;
        while(i<s.length() && s.charAt(i)!='1'){
            secondbreak++;
            i++;
        }
        return (int)(((firstbreak+1)%1000000007)*((secondbreak+1)%1000000007)%1000000007);
    }
}