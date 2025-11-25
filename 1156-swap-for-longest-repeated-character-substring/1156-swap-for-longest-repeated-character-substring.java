class Solution {
    public int maxRepOpt1(String text) {
        int[] freq=new int[26];
        for(int t:text.toCharArray()) freq[t-'a']++;

        int start=0,end=0,maxlen=0;
        int chnge=0;

        while(start<text.length() && end<text.length()){
            int countcurr=1;
            
            char ch=text.charAt(start);

            while(end<text.length()-1 && text.charAt(end+1)==ch){
                end++;countcurr++;
            }end++;chnge=end;
            while(end<text.length()-1 && text.charAt(end+1)==ch){
                end++;countcurr++;
            }maxlen=((freq[ch-'a']-countcurr)>0)?Math.max(maxlen,countcurr+1):Math.max(maxlen,countcurr);
            start=chnge;
            end=chnge;

        }return maxlen;
    }
}