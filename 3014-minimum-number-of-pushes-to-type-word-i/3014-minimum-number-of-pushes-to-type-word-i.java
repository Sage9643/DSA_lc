class Solution {
    public int minimumPushes(String word) {
        int press[]=new int[26];
        int cnt=0;
        for(char ch:word.toCharArray()){
            if(press[ch-'a']==0){
                cnt++;
                press[ch-'a']=(int)Math.ceil((double)cnt/8);
            }
        }
        int ans=0;
        for(char ch:word.toCharArray()) ans+=press[ch-'a'];

        return ans;
    }
}