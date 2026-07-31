class Solution {
    public int minimumPushes(String word) {
        int freq[]=new int[26];
        int cnt=0;

        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int ans=0;

        for(int i=freq.length-1;i>=0;i--){
            if(freq[i]==0) break;
            cnt++;
            ans+=(freq[i]*((int)Math.ceil((double)cnt/8)));


        }return ans;
    }
}