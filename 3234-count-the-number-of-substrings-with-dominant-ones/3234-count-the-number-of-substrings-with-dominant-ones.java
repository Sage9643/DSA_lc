class Solution {
    public int numberOfSubstrings(String s) {
        int freqone[]=new int[s.length()];
        freqone[0]=s.charAt(0)=='0'?0:1;

        for(int i=1;i<s.length();i++){
            freqone[i]=freqone[i-1]+(s.charAt(i)=='0'?0:1);
        }
        int cnt=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){

                int ones=freqone[j]-((i-1)>=0?freqone[i-1]:0);
                int zeroes=(j-i+1)-ones;

                if((zeroes*zeroes)>ones){
                    int skip=(zeroes*zeroes)-ones;
                    j+=skip-1;
                }else if((zeroes*zeroes)==ones) cnt++;
                else{
                    cnt++;
                    int skip=(int)Math.sqrt(ones)-zeroes;
                    int next=j+skip;

                    if(next>=s.length()){
                        cnt+=(s.length()-j-1);break;
                    }else cnt+=skip;

                    j=next;
                }
            }
        }return cnt;
    }
}