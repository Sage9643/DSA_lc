class Solution {
    public int numSub(String s) {
        ArrayList<Integer> idx=new ArrayList<>();
        char prev=s.charAt(0)=='0'?'0':'1';long modulo=1000000007;
        
        if(prev=='1')idx.add(0);

        for(int i=1;i<s.length();i++){
            if(prev=='0' && s.charAt(i)=='1') idx.add(i);
            prev=s.charAt(i);
        }long cnt=0;
        for(int i=0;i<idx.size();i++){
            int start=idx.get(i);int j=start;

            while(j<s.length() && s.charAt(j)!='0') j++;
            long len=j-start;

            cnt+=((len*(len+1)/2)%modulo);
            cnt%=modulo;
        }return (int)cnt;
    }
}